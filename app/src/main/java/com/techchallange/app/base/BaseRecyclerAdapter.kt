package com.techchallange.app.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView

/**
 * Base adapter from which the necessary features for the RecyclerView are derived.
 *
 * @author hasankucuk
 * @since 1.0
 */
abstract class BaseRecyclerAdapter<T : BaseModel, VM : BaseRecyclerItemViewModel<T>, DB : ViewDataBinding>(val activity: AppCompatActivity) :
    RecyclerView.Adapter<BaseRecyclerAdapter.ItemViewHolder<T, VM, DB>>() {

    var items: List<T> = mutableListOf()

    protected abstract fun onItemBinding(binding: DB, viewModel: VM, position: Int)

    protected abstract fun getViewModel(): VM

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder<T, VM, DB> {
        val binding = DataBindingUtil.inflate<DB>(
            LayoutInflater.from(parent.context),
            getLayoutRes(),
            parent,
            false
        )

        val viewModel = getViewModel()

        return ItemViewHolder(binding.root, binding, viewModel) { _binding, _viewModel, position ->
             onItemBinding(_binding, _viewModel, position)

            }
        }

    override fun onBindViewHolder(holder: ItemViewHolder<T, VM, DB>, position: Int) {
        holder.setItem(items[position], position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun update(items: List<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun setItem(items: List<T>) {
        this.items = items
    }

    fun update() {
        notifyDataSetChanged()
    }


    class ItemViewHolder<T : BaseModel, VM : BaseRecyclerItemViewModel<T>, DB : ViewDataBinding>(
        itemView: View,
        val binding: DB,
        val viewModel: VM,
        val onItemBinding: (binding: DB, viewModel: VM, position: Int) -> Unit
    ): RecyclerView.ViewHolder(itemView){

        internal fun setItem(item: T, position: Int){
            viewModel.model=item
            viewModel.setValues()
            binding.setVariable(BR.viewModel, viewModel)
            onItemBinding(binding, viewModel, position)
            binding.executePendingBindings()
        }
    }
}



