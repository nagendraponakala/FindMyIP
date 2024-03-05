package com.photon.feature.findmyip

import com.photon.core.common.Result
import com.photon.core.data.FindMyIpRepository
import com.photon.core.model.IpData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals

class FindMyIpViewModelTest {
    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var repository: FindMyIpRepository

    private lateinit var viewModel: FindMyIpViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
        viewModel = FindMyIpViewModel(repository)
    }

    @Test
    fun `state is initially loading`() = runTest {
        assertEquals(FindMyIpUiState.Loading, viewModel.findMyIpUiState.value, message = "${viewModel.findMyIpUiState.value}")
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test successful data retrieval`() = runTest() {
        val data= IpData(
            ip = "124.123.178.88",
            city = "Hyderabad",
            region = "Telangana",
            countryName = "India",
            postal = "500002",
            latitude = 17.3724,
            longitude = 78.4378
        )

        `when`(repository.findMyIp()).thenReturn(flowOf(Result.Success(data)))

        viewModel.findMyIpUiState.collect()

        assertEquals(viewModel.findMyIpUiState.value, FindMyIpUiState.Success(data))
    }
}