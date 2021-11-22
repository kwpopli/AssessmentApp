package com.example.assessmentapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.assessmentapp.data.repository.IVenueListRepository
import com.example.assessmentapp.ui.model.VenueDetailsModel
import com.example.assessmentapp.ui.model.VenueListModel
import com.example.assessmentapp.util.TestMyDispatchers
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class VenueListViewModelTest {

    var instantExecutorRule = InstantTaskExecutorRule()
        @Rule get

    private lateinit var venueListViewModel: VenueListViewModel

    private val venueListModelString =
        "[{\"id\":0,\"nearBy\":\"london\",\"venueAddress\":\"Strand, London, Greater London, WC2N 5HF, United Kingdom\",\"venueId\":\"4ac518f6f964a52050af20e3\",\"venueName\":\"Charing Cross Railway Station (CHX) (Charing Cross Railway Station)\"},{\"id\":0,\"nearBy\":\"london\",\"venueAddress\":\"Trafalgar Sq, London, Greater London, WC2N 5DX, United Kingdom\",\"venueId\":\"4ac518cef964a520f9a520e3\",\"venueName\":\"Trafalgar Square\"},{\"id\":0,\"nearBy\":\"london\",\"venueAddress\":\"Trafalgar Sq (at Strand), London, Greater London, WC2N 5DR, United Kingdom\",\"venueId\":\"4bfd71712b83b713bbb7a998\",\"venueName\":\"Charing Cross London Underground Station\"},{\"id\":0,\"nearBy\":\"london\",\"venueAddress\":\"450 Strand, London, Greater London, WC2R 0RG, United Kingdom\",\"venueId\":\"4b5061def964a520cb2127e3\",\"venueName\":\"Pizza Express\"},{\"id\":0,\"nearBy\":\"london\",\"venueAddress\":\"The Strand (Villliers St), London, Greater London, WC2N 5HF, United Kingdom\",\"venueId\":\"52024d08498eb0286116073e\",\"venueName\":\"Charing Cross Station Bus Stop H\"},{\"id\":0,\"nearBy\":\"london\",\"venueAddress\":\"Adelaide St. (Btw King William IV \\u0026 Duncannon), London, Greater London, WC2 N 5, United Kingdom\",\"venueId\":\"4cb1d0e2562d224bfdb42188\",\"venueName\":\"\\\"A Conversation With Oscar Wilde\\\" statue\"},{\"id\":0,\"nearBy\":\"london\",\"venueAddress\":\"Duncannon, London, Greater London, United Kingdom\",\"venueId\":\"51cad78b498eebb99437f4fc\",\"venueName\":\"Café In The Courtyard\"},{\"id\":0,\"nearBy\":\"london\",\"venueAddress\":\"Charing Cross Railway Station (CHX), London, Greater London, WC2 5HS, United Kingdom\",\"venueId\":\"4bc3435274a9a593e941d4f6\",\"venueName\":\"Platform 1\"},{\"id\":0,\"nearBy\":\"london\",\"venueAddress\":\"450 Strand, London, Greater London, WC2R 0RG, United Kingdom\",\"venueId\":\"4bcc979fb6c49c7417029491\",\"venueName\":\"Jigsaw\"},{\"id\":0,\"nearBy\":\"london\",\"venueAddress\":\"The Piazza, London, Greater London, WC2E 8RF, United Kingdom\",\"venueId\":\"4ba6419bf964a520b23f39e3\",\"venueName\":\"Covent Garden Market\"}]"

    private lateinit var venueList: List<VenueListModel>

    private var venueDetailsModel: VenueDetailsModel = VenueDetailsModel(
        "venueId",
        "venueName",
        "venueAddress",
        "venueDescription",
        "venueRating",
        "venueContact",
        "venueImageUrl")

    @Mock
    lateinit var venueListRepository: IVenueListRepository

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        venueListViewModel = VenueListViewModel(venueListRepository, TestMyDispatchers())
        venueList = Gson().fromJson(
            venueListModelString,
            object : TypeToken<List<VenueListModel>>() {}.type
        )
    }

    @Test
    fun testGetVenueListAfterMockingValueSuccess() {
        runBlocking {
            Mockito.`when`(venueListRepository.getVenueList("london")).thenReturn(venueList)
            venueListViewModel.getVenueList("london")
            venueListViewModel.venueListLiveData.observeForever {
                Assert.assertEquals(venueList, it)
            }
        }
    }

    @Test
    fun testGetVenueListWithoutMockingValueFailure() {
        runBlocking {
            venueListViewModel.getVenueList("london")
            venueListViewModel.venueListLiveData.observeForever {
                Assert.assertNull(it)
            }
        }
    }

    @Test
    fun testGetVenueDetailsAfterMockingValueSuccess() {
        runBlocking {
            Mockito.`when`(venueListRepository.getVenueDetails("venueId")).thenReturn(venueDetailsModel)
            venueListViewModel.getVenueDetails("venueId")
            venueListViewModel.venueDetailsLiveData.observeForever {
                Assert.assertEquals(venueDetailsModel, it)
            }
        }
    }

    @Test
    fun testGetVenueDetailsWithoutMockingValueSuccess() {
        runBlocking {
            venueListViewModel.getVenueDetails("venueId")
            venueListViewModel.venueDetailsLiveData.observeForever {
                Assert.assertNull(it)
            }
        }
    }

}