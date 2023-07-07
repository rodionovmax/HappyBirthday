package com.example.happybirthday

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

const val greenFontInt = 0xFF1D5A1D
const val greenBackgroundInt = 0xFFD2E8D4
const val blueAvatarBackgroundInt = 0xFF063042

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .background(Color(greenBackgroundInt))
    ) {
        PersonalInformation(
            fullName = stringResource(R.string.full_name_text),
            title = stringResource(R.string.title_text),
            modifier = modifier.align(Alignment.Center)
        )
        ContactInformation(
            modifier = modifier
                .padding(bottom = 50.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Avatar(modifier: Modifier = Modifier) {
    Column(
        modifier
            .width(120.dp)
            .aspectRatio(1f)
            .background(color = Color(blueAvatarBackgroundInt), shape = RectangleShape),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android logo",
            modifier
                .width(100.dp)
                .aspectRatio(1f)
        )
    }
}

@Composable
fun PersonalInformation(fullName: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Avatar()
        Text(
            text = fullName,
            fontSize = 36.sp
        )
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color(greenFontInt)
        )
    }
}

@Composable
fun ContactInformation(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            ContactType(
                icon = R.drawable.ic_phone_24,
                iconContentDescription = stringResource(R.string.phone_icon_content_desc),
                contactInfo = stringResource(R.string.contact_phone_text)
            )
            ContactType(
                icon = R.drawable.ic_share_24,
                iconContentDescription = stringResource(R.string.share_icon_content_desc),
                contactInfo = stringResource(R.string.contact_share_text)
            )
            ContactType(
                icon = R.drawable.ic_email_24,
                iconContentDescription = stringResource(R.string.email_icon_content_desc),
                contactInfo = stringResource(R.string.contact_email_text)
            )
        }
    }
}

@Composable
fun ContactType(icon: Int, iconContentDescription: String, contactInfo: String) {
    Row(
        Modifier
            .padding(vertical = 6.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = iconContentDescription,
            Modifier
                .width(24.dp)
                .aspectRatio(1f),
            tint = Color(greenFontInt) // how to extract Color to outside var
        )
        Text(
            text = contactInfo,
            Modifier
                .padding(horizontal = 24.dp)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = "Background image",
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        GreetingText(
            message = message,
            from = from,
            modifier = modifier
        )
    }
}

@Composable
fun GreetingText(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        BusinessCard()
    }
}