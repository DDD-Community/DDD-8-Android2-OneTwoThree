package com.inseoul.designsystem.dropdownmenu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InSeoulDropDownMenu(list: List<String>) {

    val expanded = remember { mutableStateOf(false) }
    val currentValue = remember { mutableStateOf(list[0]) }

    val icon = if (expanded.value)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .height(24.dp)
                .width(154.dp)
                .clickable {
                    expanded.value = !expanded.value
                }) {
            Text(text = currentValue.value)
            Icon(imageVector = icon, contentDescription = "DropDownIcon")


            DropdownMenu(expanded = expanded.value,
                onDismissRequest = {
                    expanded.value = false
                }) {
                list.forEach {
                    DropdownMenuItem(onClick = {
                        currentValue.value = it
                        expanded.value = false
                    }) {
                        Text(text = it)
                    }
                }
            }
        }
    }
}
