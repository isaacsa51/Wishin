package com.serranoie.wishin.presentation.survey

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.serranoie.wishin.data.persistance.db.entity.CategoryWithItems
import com.serranoie.wishin.domain.usecases.item.AddItemUseCase
import com.serranoie.wishin.presentation.survey.questions.Category
import com.serranoie.wishin.presentation.survey.questions.SurveyScreenData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

const val simpleDateFormatPattern = "EEE, MMM d"

@HiltViewModel
class SurveyViewModel @Inject constructor(
    private val addItemUseCase: AddItemUseCase,
) : ViewModel() {
    private val questionOrder: List<Questions> = listOf(
        Questions.NAME,
        Questions.CATEGORY,
        Questions.USAGE,
        Questions.BENEFITS,
        Questions.CONTRAS,
        Questions.REMINDER,
    )

    private var questionIndex = 0
    private var currentItem: CategoryWithItems? = null

    // Responses exposed as State
    private val _nameItemResponse = mutableStateOf("")
    val nameItemResponse: String
        get() = _nameItemResponse.value

    private val _categoryResponse = mutableStateOf<Category?>(null)
    val categoryResponse: Category?
        get() = _categoryResponse.value

    private val _benefitsResponse = mutableStateOf("")
    val benefitsResponse: String
        get() = _benefitsResponse.value

    private val _contrasResponse = mutableStateOf("")
    val contrasResponse: String
        get() = _contrasResponse.value

    private val _usageResponse = mutableStateOf<Float?>(null)
    val usageResponse: Float?
        get() = _usageResponse.value

    private val _reminderResponse = mutableStateOf<Long?>(null)
    val reminderResponse: Long?
        get() = _reminderResponse.value

    // Survey status exposed as State
    private val _surveyScreenData = mutableStateOf(createSurveyScreenData())
    val surveyScreenData: SurveyScreenData?
        get() = _surveyScreenData.value

    private val _isNextEnabled = mutableStateOf(false)
    val isNextEnabled: Boolean
        get() = _isNextEnabled.value

    /**
     * Returns true if the ViewModel handled the back press (i.e., it went back one question)
     */
    fun onBackPressed(): Boolean {
        if (questionIndex == 0) {
            return false
        }
        changeQuestion(questionIndex - 1)
        return true
    }

    fun onPreviousPressed() {
        if (questionIndex == 0) {
            throw IllegalStateException("onPreviousPressed when on question 0")
        }
        changeQuestion(questionIndex - 1)
    }

    fun onNextPressed() {
        changeQuestion(questionIndex + 1)
    }

    private fun changeQuestion(newQuestionIndex: Int) {
        questionIndex = newQuestionIndex
        _isNextEnabled.value = getIsNextEnabled()
        _surveyScreenData.value = createSurveyScreenData()
    }

    fun onDonePressed(onSurveyComplete: () -> Unit) {
        // Here is where you could validate that the requirements of the survey are complete
        onSurveyComplete()
    }

    fun onNameResponse(itemName: String) {
        _nameItemResponse.value = itemName
        _isNextEnabled.value = getIsNextEnabled()
    }

    fun onCategoryResponse(category: Category) {
        _categoryResponse.value = category
        _isNextEnabled.value = getIsNextEnabled()
    }

    fun onUsageResponse(usage: Float) {
        _usageResponse.value = usage
        _isNextEnabled.value = getIsNextEnabled()
    }

    fun onBenefitsResponse(reasonsTo: String) {
        _benefitsResponse.value = reasonsTo
        _isNextEnabled.value = getIsNextEnabled()
    }

    fun onContrasResponse(reasonsNotTo: String) {
        _contrasResponse.value = reasonsNotTo
        _isNextEnabled.value = getIsNextEnabled()
    }

    fun onReminderResponse(timestamp: Long) {
        _reminderResponse.value = timestamp
        _isNextEnabled.value = getIsNextEnabled()
    }

    private fun getIsNextEnabled(): Boolean {
        return when (questionOrder[questionIndex]) {
            Questions.NAME -> true
            Questions.CATEGORY -> _categoryResponse.value != null
            Questions.USAGE -> _usageResponse.value != null
            Questions.BENEFITS -> true
            Questions.CONTRAS -> true
            Questions.REMINDER -> true
        }
    }

    private fun createSurveyScreenData(): SurveyScreenData {
        return SurveyScreenData(
            questionIndex = questionIndex,
            questionCount = questionOrder.size,
            shouldShowPreviousButton = questionIndex > 0,
            shouldShowDoneButton = questionIndex == questionOrder.size - 1,
            surveyQuestion = questionOrder[questionIndex],
        )
    }
}
