package com.photon.feature.findmyip

import com.photon.core.common.Result
import com.photon.core.data.FindMyIpRepository
import com.photon.core.model.IpData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class FindMyIpViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    @Mock
    private lateinit var repository: FindMyIpRepository

    private lateinit var viewModel: FindMyIpViewModel

    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
        repository = mock(FindMyIpRepository::class.java)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test successful data retrieval`() = runTest{
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

        viewModel = FindMyIpViewModel(repository)

        val collectJob = launch(UnconfinedTestDispatcher()) {
            viewModel.findMyIpUiState.collect()
        }

        println("state: ${viewModel.findMyIpUiState.value}")

        assertTrue(viewModel.findMyIpUiState.value is FindMyIpUiState.Success)

        assertEquals(
            expected = FindMyIpUiState.Success(data = data).data.ip,
            actual = (viewModel.findMyIpUiState.value as FindMyIpUiState.Success).data.ip
        )

        collectJob.cancel()
    }
}