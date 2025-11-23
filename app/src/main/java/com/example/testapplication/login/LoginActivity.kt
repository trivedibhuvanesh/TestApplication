package com.example.testapplication.login

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapplication.R
import com.example.testapplication.login.ui.theme.TestApplicationTheme
import com.example.testapplication.ui.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestApplicationTheme {
                Scaffold(
                    modifier = Modifier.padding(top = 12.dp).fillMaxSize(),
                    containerColor = Color.White
                ) { innerPadding ->
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Greeting(
    login: (() -> Unit)
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.mipmap.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(40.dp)
            )

            Text(
                "Logoipsum",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
        }

        Text(
            "Sign in to your Account",
            modifier = Modifier
                .padding(vertical = 14.dp)
                .wrapContentSize(),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = Color.Black,
            lineHeight = 48.sp
        )

        Text(
            "Enter your email and password to log in",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Text(
            "Email",
            fontSize = 12.sp,
            color = Color.Gray
        )

        val isEmailFocused = remember { mutableStateOf(false) }
        val email = remember { mutableStateOf("") }


        TextField(
            modifier = Modifier
                .padding(top = 4.dp)
                .fillMaxWidth()
                .border(
                    1.dp,
                    color = if (isEmailFocused.value) Color.Black
                    else Color(0xFFE5E7E8),
                    shape = RoundedCornerShape(8.dp)
                )
                .onFocusChanged {
                    isEmailFocused.value = it.isFocused
                },
            value = email.value,
            onValueChange = { email.value = it },
            placeholder = {
                Text(text = "Email")
            },
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
            )

        )

        val isPasswordFocused = remember { mutableStateOf(false) }
        val isPasswordVisible = remember { mutableStateOf(false) }
        val password = remember { mutableStateOf("") }

        Text(
            "Password",
            modifier = Modifier.padding(top = 12.dp),
            fontSize = 12.sp,
            color = Color.Gray
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,
                    color = if (isPasswordFocused.value) Color.Black else Color(0xFFE5E7E8),
                    shape = RoundedCornerShape(8.dp)
                ).onFocusChanged {
                    isPasswordFocused.value = it.isFocused
                },
            value = password.value,
            visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            onValueChange = {
                password.value = it
            },
            placeholder = {
                Text(text = "Password")
            },
            trailingIcon = {
                IconButton(onClick = {
                    isPasswordVisible.value = isPasswordVisible.value.not()
                }) {
                    Icon(
                        imageVector = if (isPasswordVisible.value) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Visibility"
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
            )

        )

        Text(
            "Forgot Password?",
            fontSize = 12.sp,
            color = colorResource(R.color.primaryBlue),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp).align(Alignment.End)
        )
        val context = LocalContext.current

        ElevatedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            onClick = {
                // Step 1: Check if email is empty
                if (email.value.isEmpty()) {
                    showToast("Please enter your email", context)
                    return@ElevatedButton
                }

                // Step 2: Check if email format is valid
                if (!isValidEmail(email.value)) {
                    Toast.makeText(context, "Please enter a valid email", Toast.LENGTH_SHORT).show()
                    return@ElevatedButton
                }

                // Step 3: Check if password is empty
                if (password.value.isEmpty()) {
                    showToast("Please enter your password", context)
                    return@ElevatedButton
                }

                // Step 4: Check password length
                if (password.value.length < 6) {
                    showToast("Password must be at least 6 characters", context)
                    return@ElevatedButton
                }

                login.invoke()
            },
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.primaryBlue),
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 16.dp
            )
        ) {
            Text("Log In")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Or",
                color = Color.Gray,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.weight(1f)
            )

        }


        Button(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(60.dp)
                .border(1.dp, Color(0xFFE5E7E8), RoundedCornerShape(14.dp)),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White,
            )
        ) {
            Image(
                painter = painterResource(id = R.mipmap.google_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(40.dp)
                    .padding(horizontal = 4.dp)
            )
            Text(
                "Continue with Google",
                color = Color.Black
            )
        }

        Button(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(60.dp)
                .border(1.dp, Color(0xFFE5E7E8), RoundedCornerShape(14.dp)),
            onClick = {


            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White,
            )
        ) {
            Image(
                painter = painterResource(id = R.mipmap.facebook_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(40.dp)
                    .padding(horizontal = 4.dp)
            )
            Text(
                "Continue with Facebook",
                color = Color.Black
            )
        }

        Row(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Don't have a account?",
                color = Color.Gray
            )

            Text(
                "Sign Up",
                color = colorResource(R.color.primaryBlue)
            )
        }
    }

}

fun showToast(msg: String, context: Context) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}

fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    return email.matches(emailRegex)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestApplicationTheme {
        Greeting() {

        }
    }
}