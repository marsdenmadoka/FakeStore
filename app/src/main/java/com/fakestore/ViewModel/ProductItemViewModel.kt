package com.fakestore.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fakestore.Repository.ProductRepository
import com.fakestore.Room.ProductEntity
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


//displaying a single product
@HiltViewModel
class ProductItemViewModel @Inject constructor(
    /**we can use the SavedStateHandle to store pieces of information to restore/recreating our ui
     * but also store the navigation arguments we sent over to this screen **/
    private val state:SavedStateHandle,
    repository: ProductRepository,
): ViewModel() {
    val product = state.get<ProductEntity>("ProductItem") //key of te argument MUST be the same with that from the navgraph

    var productItemName = state.get<String>("productItemName") ?:product?.title ?:""
    set(value) {
        field=value
        state.set("productItemName",value)
    }


    var productItemCategory = state.get<String>("productItemCategory") ?:product?.category ?:""
        set(value) {
            field=value
            state.set("productItemCategory",value)
        }


    var productItemImage = state.get<String>("productItemImage") ?:product?.image?:""
        set(value) {
            field=value
            state.set("productItemImage",value)
        }


}