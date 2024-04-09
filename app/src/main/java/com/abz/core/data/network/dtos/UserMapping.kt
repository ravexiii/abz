package com.abz.core.data.network.dtos

import com.abz.core.domain.model.User

fun UserDto.toUser(): User {
    return User(
        email = email,
        firstName = firstName,
        lastName = lastName,
        avatar = avatar
    )
}