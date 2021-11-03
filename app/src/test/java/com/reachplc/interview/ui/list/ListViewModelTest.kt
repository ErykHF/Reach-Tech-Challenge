package com.reachplc.interview.ui.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.reachplc.interview.data.remote.ProductsRepository
import com.reachplc.interview.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeoutException
import kotlin.jvm.Throws


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ListViewModelTest {

    private lateinit var listViewModel: ListViewModel
    private val repository =
        ProductsRepository.initialize(ApplicationProvider.getApplicationContext())
    private val dispatcher = TestCoroutineDispatcher()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setup() {
        repository
        Dispatchers.setMain(dispatcher)
        listViewModel = ListViewModel()

    }


    //Will fail and throw NullPointerException if not connected to the internet
    @Test
    fun `check that livedata receives data from the api call`() = runBlockingTest {
        listViewModel.getBeautyProducts()

        val value = listViewModel.beautyProducts.getOrAwaitValue()

        for (i in value!!) {
            println(i.name)
            assertThat(i.name).isNotEmpty()
        }

        assertThat(value).isNotEmpty()
    }
}