package com.serranoie.wishin.presentation.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.serranoie.wishin.presentation.onboarding.components.OnBoardingPage
import com.serranoie.wishin.presentation.onboarding.components.PageIndicator
import com.serranoie.wishin.presentation.utils.Dimens.mediumPadding
import com.serranoie.wishin.presentation.utils.Dimens.pageIndicatorWidth
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = mediumPadding)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PageIndicator(
                modifier = Modifier.width(pageIndicatorWidth),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage,
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                val scope = rememberCoroutineScope()

                if (buttonState.value[0].isNotEmpty()) {
                    TextButton(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                            }
                        },
                    ) {
                        Text(text = buttonState.value[0])
                    }
                }

                Button(
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage == 2) {
                                /*TODO: Navigate to HomeScreen */
                            } else {
                                pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                            }
                        }
                    },
                ) {
                    Text(text = buttonState.value[1])
                }
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@PreviewLightDark
@Composable
private fun PreviewOnBoardingScreen() {
    OnBoardingScreen()
}
