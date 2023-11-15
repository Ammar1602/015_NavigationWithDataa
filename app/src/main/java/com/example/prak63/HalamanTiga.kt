package com.example.prak63

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.prak63.data.OrderUIState
import com.example.prak63.ui.theme.Komponen.FormatLabelHarga

@Composable
fun HalamanTiga(
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
    orderUIState: OrderUIState
){
    val items = listOf(
        Pair(stringResource(id = R.string.nama), orderUIState.nama),
        Pair(stringResource(id = R.string.nomorhp), orderUIState.noTelp),
        Pair(stringResource(id = R.string.alamat), orderUIState.alamat),
        Pair(stringResource(id = R.string.quantity), orderUIState.jumlah),
        Pair(stringResource(id = R.string.flavor), orderUIState.rasa),
    )
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            items.forEach{ items ->
                Column {
                    Text(text = items.second.toString(),
                        fontWeight = FontWeight.Bold)
                }
                Divider(
                    thickness = dimensionResource(id = R.dimen.thicknes_divider)
                )
            }
            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.padding_small)))
            FormatLabelHarga(subtotal = orderUIState.harga,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Row(
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
            ) {
                Button(
                    modifier = Modifier,
                    onClick = {}
                ) {
                    Text(stringResource(R.string.send))
                }
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        }
    }
}