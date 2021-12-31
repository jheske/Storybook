package com.example.compose.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.Composable

// TODO Dematerialize

@Composable
public fun PasswordIcon(
    isVisible: Boolean,
    contentDescription: String = "",
    flipVisibility: () -> Unit) {

    val image =
        if (isVisible) Icons.Outlined.Visibility
        else Icons.Outlined.VisibilityOff

    IconButton(onClick = {
        flipVisibility()
    }) {
        Icon(imageVector  = image, contentDescription)
    }
}


object McIcons  {

    val locked: @Composable (() -> Unit)? = {
        Icon(
            imageVector = Icons.Outlined.Lock,
            contentDescription = null
        )
    }

    val person: @Composable (() -> Unit)? = {
        Icon(
            imageVector = Icons.Outlined.Person,
            contentDescription = null
        )
    }
}