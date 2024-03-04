package com.photon.feature.findmyip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.photon.core.model.IpData


@Composable
fun FindMyIpRoute(
    viewModel: FindMyIpViewModel = hiltViewModel()
) {
    val findMyIpUiState by viewModel.findMyIpUiState.collectAsStateWithLifecycle()
    FindMyIpScreen(
        uiState = findMyIpUiState
    )
}

@Composable
internal fun FindMyIpScreen(
    uiState: FindMyIpUiState
) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.surface)
    ){
        TopAppBar()
        when(uiState){
            is FindMyIpUiState.Error -> {
                uiState.message?.let {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = it,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
            FindMyIpUiState.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }
            is FindMyIpUiState.Success -> {
                Box(
                    contentAlignment = Alignment.TopStart,
                    modifier = Modifier.fillMaxSize()
                ) {
                    FindMyIpDetailsScreen(uiState.data)
                }
            }
        }
    }
}

@Composable
fun FindMyIpDetailsScreen(data: IpData) {
    val dataAsList: List<Pair<String, String>> = listOf(
        "IP" to data.ip,
        "City" to data.city,
        "State" to data.region,
        "Country" to data.countryName,
        "ZipCode" to data.postal
    )
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        dataAsList.forEach { it ->
            Column{
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = it.first,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                        ,
                        modifier = Modifier.padding(16.dp)
                    )
                    Text(
                        text = it.second,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = MaterialTheme.colorScheme.primary
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = com.photon.core.designsystem.R.drawable.hexa),
            contentDescription = "Photon - Find My IP",
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = "Find My IP",
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        )
    }
}



@Preview
@Composable
fun FindMyIpScreenPreview() {
    FindMyIpScreen(
        uiState = FindMyIpUiState.Success(
            data = IpData(
                ip = "124.123.178.88",
                city = "Hyderabad",
                region = "Telangana",
                countryName = "India",
                postal = "500002",
                latitude = 17.3724,
                longitude = 78.4378
            )
        )
    )
}

@Preview
@Composable
fun FindMyIpDetailsScreenPreview() {
    FindMyIpDetailsScreen(
        data = IpData(
            ip = "124.123.178.88",
            city = "Hyderabad",
            region = "Telangana",
            countryName = "India",
            postal = "500002",
            latitude = 17.3724,
            longitude = 78.4378
        )
    )
}