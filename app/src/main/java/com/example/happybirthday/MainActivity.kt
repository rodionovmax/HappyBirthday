package com.example.happybirthday

import android.graphics.Paint
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

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
                    /*GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(
                            R.string.signature_text
                        )
                    )*/
                    /*LearnTogether()*/
                    /*TaskCompleted(
                        status = stringResource(R.string.status_text),
                        comment = stringResource(
                            R.string.comment_text
                        )
                    )*/
                    Quadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant() {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            Section(
                title = stringResource(R.string.title_1),
                text = stringResource(R.string.text_1),
                color = colorResource(R.color.section_1),
                modifier = Modifier.weight(1f)
            )
            Section(
                title = stringResource(R.string.title_2),
                text = stringResource(R.string.text_2),
                color = colorResource(R.color.section_2),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Section(
                title = stringResource(R.string.title_3),
                text = stringResource(R.string.text_3),
                color = colorResource(R.color.section_3),
                modifier = Modifier.weight(1f)
            )
            Section(
                title = stringResource(R.string.title_4),
                text = stringResource(R.string.text_4),
                color = colorResource(R.color.section_4),
                modifier = Modifier.weight(1f)
            )
        }
    }

}

@Composable
fun Section(title: String, text: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color = color)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskCompleted(
    status: String,
    comment: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = "task completed image",
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit
        )
        Text(
            text = status,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = comment,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LearnTogether(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Header()
        Title(modifier = modifier)
        Article(modifier = modifier)
    }
}

@Composable
fun Header() {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = "Header image",
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun Title(modifier: Modifier) {
    Text(
        text = stringResource(R.string.title_text),
        fontSize = 28.sp,
        modifier = modifier
            .padding(16.dp)
    )

}

@Composable
fun Article(modifier: Modifier) {
    Text(
        text = stringResource(R.string.paragraph_1),
        fontSize = 18.sp,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(horizontal = 16.dp)
    )
    Text(
        text = stringResource(R.string.paragraph_2),
        fontSize = 18.sp,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(16.dp)
    )
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
        /*GreetingImage(
            message = stringResource(R.string.happy_birthday_text),
            from = stringResource(
                R.string.signature_text
            )
        )*/
        /*TaskCompleted(
            status = stringResource(R.string.status_text),
            comment = stringResource(
                R.string.comment_text
            )
        )*/
        Quadrant()
    }
}
