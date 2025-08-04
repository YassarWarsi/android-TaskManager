package com.example.taskmanager


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Surface (modifier = Modifier.fillMaxSize()){
                    TaskManager(
                        header = stringResource(R.string.header),
                        compliment = stringResource(R.string.compliment)

                    )
                }
            }
        }
    }
}

@Composable
fun TaskManager(header: String,compliment: String, modifier: Modifier = Modifier) {

    val image = painterResource(R.drawable.ic_task_completed)

    Box(modifier= modifier,
        contentAlignment = Alignment.Center) {

        Column (modifier = modifier) {
            Image(
                painter = image,
                contentDescription = null,
                alignment = Alignment.Center
            )
            Text(
                text = header,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(top = 24.dp , bottom = 8.dp)
                    .align(alignment = Alignment.CenterHorizontally),

            )
            Text(
                text = compliment,
                fontSize = 16.sp,
                modifier = modifier.align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskManagerPreview() {
    TaskManagerTheme {
        TaskManager(header = stringResource(R.string.header),
            compliment = stringResource(R.string.compliment))
    }
}