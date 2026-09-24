package com.ranielschneider.atmsimulator.data

import com.ranielschneider.atmsimulator.model.User
import java.math.BigDecimal

val users = mutableListOf<User>(
    User("John Doe", 1234, BigDecimal("1000.00"))
)