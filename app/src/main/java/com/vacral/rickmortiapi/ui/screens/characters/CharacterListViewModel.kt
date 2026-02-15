package com.vacral.rickmortiapi.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.vacral.rickmortiapi.domain.models.Character
import com.vacral.rickmortiapi.domain.models.CharacterParams
import com.vacral.rickmortiapi.domain.usecase.GetCharactersPageSourceUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.stateIn
import okhttp3.Dispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import org.koin.core.component.KoinComponent

class CharacterListViewModel(
    private val getCharactersPageSourceUseCase: GetCharactersPageSourceUseCase
) : ViewModel(){

  //  val scope = CoroutineScope(Dispatchers.Main  + SupervisorJob())

    val pagingData = getCharactersPageSourceUseCase(CharacterParams(page = 1))
        .cachedIn(viewModelScope)
        .stateIn(scope = viewModelScope, started = SharingStarted.Lazily, initialValue = PagingData.empty()
    )

}