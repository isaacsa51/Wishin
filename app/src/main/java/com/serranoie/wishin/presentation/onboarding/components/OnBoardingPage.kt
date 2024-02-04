package com.serranoie.wishin.presentation.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.serranoie.wishin.presentation.onboarding.Page
import com.serranoie.wishin.presentation.onboarding.pages
import com.serranoie.wishin.presentation.utils.Dimens.mediumPadding
import com.serranoie.wishin.ui.theme.WishinTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page,
) {
    Column(modifier = Modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = "OnBoarding image",
            contentScale = ContentScale.Fit,
        )

        Spacer(modifier = Modifier.height(mediumPadding))

        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = mediumPadding),
            style = MaterialTheme.typography.displaySmall,
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = mediumPadding),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PreviewOnBoardingPage() {
    WishinTheme {
        Surface {
            OnBoardingPage(page = pages[0])
        }
    }
}
