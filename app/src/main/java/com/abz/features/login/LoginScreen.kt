package com.abz.features.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abz.R
import com.abz.arch.extensions.collectAsStateLifecycleAware
import com.abz.core.ui.AppBackground
import com.abz.core.ui.AppButton
import com.abz.core.ui.InputTextField


@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToHome: () -> Unit = {}
) {
    val loginUiInfo = viewModel.loginUiInfo.collectAsStateLifecycleAware().value
    LoginScreen(
        loginUiInfo = loginUiInfo,
        onUserNameChanged = viewModel::onUserNameChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        login = viewModel::login,
        navigateToHome = navigateToHome
    )
}

@Composable
fun LoginScreen(
    loginUiInfo: LoginUiInfo,
    onUserNameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    login: () -> Unit,
    navigateToHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = "Login Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
        )
        InputTextField(
            label = stringResource(id = R.string.login),
            text = loginUiInfo.userName
        ) {
            onUserNameChanged(it)
        }
        Spacer(modifier = Modifier.height(10.dp))
        InputTextField(
            label = stringResource(id = R.string.password),
            text = loginUiInfo.password) {
            onPasswordChanged(it)
        }
        Spacer(modifier = Modifier.height(20.dp))
        AppButton(text = stringResource(id = com.abz.R.string.login)) {
            //TODO call  login()
            navigateToHome()
        }

    }

}

@Preview
@Composable
fun LoginPreview() {
    AppBackground {
        LoginScreen(LoginUiInfo("", ""), {}, {}, {}, {})
    }
}