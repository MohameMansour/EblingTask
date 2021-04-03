package com.dro.eblingtask.home


import junit.framework.TestCase
import org.junit.Test

//
//@ExperimentalCoroutinesApi
//@RunWith(MockitoJUnitRunner::class)

class HomeRepositoryTest : TestCase() {

//    @get:Rule
//    val rule = InstantTaskExecutorRule()

    private lateinit var repository: HomeRepository

    @Test
    suspend fun testTrendMovies(sort: String?, page: Int?) {
        val myObjectUnderTest = repository.trendMovies(sort, page)

        var success: List<TrendMovieModel>? = null
        var errorMessage: Throwable? = null

        // Assert
        assertNull(errorMessage)
        assertNotNull(success)
        assertEquals(success!!, myObjectUnderTest)
    }

//    @Mock
//    private lateinit var trendMovieViewModel: TrendMovieViewModel
//
//    @Mock
//    private lateinit var trendMovieViewModel: TrendMovieViewModel
//
//    @Test
//    fun `testTrendMovies() with success response then return response`(sort: String?, page: Int?) {
//        runBlocking {
//            //Arrange
//            val movie = mock(TrendMovieViewModel::class.java)
//            val result = listOf(movie)
//
//            `when`(trendMovieViewModel.getTrendMovies(sort, page)).thenReturn()
//
//            //Act
//            val response = repository.trendMovies(sort, page)
//
//            var success: List<TrendMovieModel>? = null
//            var errorMessage: Throwable? = null
//
//
//            // Assert
//            assertNull(errorMessage)
//            assertNotNull(success)
//            assertEquals(success!!, result)

}