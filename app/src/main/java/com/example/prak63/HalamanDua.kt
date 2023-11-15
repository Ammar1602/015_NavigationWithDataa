package com.example.prak63

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource

@Composable
fun HalamanDua(
    pilihanRasa : List<String>,
    onSelectionChanged : (String) -> Unit,
    onConfirmButtonClicked : (Int) -> Unit,
    onNextButtonClicked : () -> Unit,
    onCancelButtonClicked : () -> Unit,
    modifier: Modifier = Modifier
){
    var rasaYgDipilih by rememberSaveable { mutableStateOf("")}
    var textJmlBeli by rememberSaveable { mutableStateOf("")}

    Column(modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween){
        Column (modifier =
        Modifier.padding(dimensionResource(R.dimen.padding_medium))) {
            pilihanRasa.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = rasaYgDipilih == item,
                    onClick = {
                        rasaYgDipilih = item
                        onSelectionChanged(item)
                    }
                ),
                    verticalAlignment = Alignment.CenterVertically){
                    RadioButton(selected = rasaYgDipilih == item,
                        onClick = {
                            rasaYgDipilih = item
                            onSelectionChanged(item)}
                    )
                    Text(item)
                }
            }
            Divider(
                thickness = dimensionResource(R.dimen.thicknes_divider),
                modifier = Modifier.padding(bottom =
                dimensionResource(R.dimen.padding_medium))
            )
}