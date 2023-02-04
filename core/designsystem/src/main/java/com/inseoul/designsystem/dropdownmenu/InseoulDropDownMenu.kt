package com.inseoul.designsystem.dropdownmenu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inseoul.designsystem.icon.InseoulIcons

@Composable
fun InSeoulDropDownMenu(
    list: List<String>,
    currentValue: MutableState<String>
) {

    val expanded = remember { mutableStateOf(false) }
    // val currentValue = remember { mutableStateOf(list[0]) }

    val icon = if (expanded.value)
        InseoulIcons.ArrowIncreaseMono
    else
        InseoulIcons.ArrowDecreaseMono

    Box(
        //modifier = Modifier.fillMaxWidth()
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .width(154.dp)
                    .height(24.dp)
                    .clickable {
                        expanded.value = !expanded.value
                    }) {

                Text(
                    modifier = Modifier
                        .weight(1f)
                        .width(122.dp),
                    text = currentValue.value, fontSize = 18.sp
                )

                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "DropDownIcon",
                    modifier = Modifier.padding(top = 8.dp)
                )

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
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .height(2.dp)
                    .width(154.dp)
            )
        }
    }
}
