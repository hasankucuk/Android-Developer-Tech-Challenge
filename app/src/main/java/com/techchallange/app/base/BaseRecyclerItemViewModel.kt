package com.techchallange.app.base

/**
 * Base class used for RecyclerView items.
 *
 * @author hasankucuk
 * @since 1.0
 */
abstract class BaseRecyclerItemViewModel<M: BaseModel>: BaseViewModel() {

    lateinit var model:M

    abstract fun setValues()
}