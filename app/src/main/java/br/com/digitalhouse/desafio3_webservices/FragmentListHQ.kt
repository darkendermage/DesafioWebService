package br.com.digitalhouse.desafio3_webservices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.desafio3_webservices.model.ListHQAdapter
import br.com.digitalhouse.desafio3_webservices.model.ListHQViewModel
import br.com.digitalhouse.desafio3_webservices.repository.repo
import kotlinx.android.synthetic.main.fragment_list_h_q.view.*

class FragmentListHQ : Fragment(), ListHQAdapter.onClickLIstenerHQ {

    var offset = 1
    private lateinit var adapterHQ: ListHQAdapter
    private lateinit var layoutManagerHQ: GridLayoutManager

    private val viewModel by viewModels<ListHQViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ListHQViewModel(repo) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_h_q, container, false)

        layoutManagerHQ = GridLayoutManager(context, 3)
        view.rv_fragment_list_HQ.layoutManager = layoutManagerHQ

        view.rv_fragment_list_HQ.setHasFixedSize(true)

        viewModel.listComics.observe(viewLifecycleOwner, {
            adapterHQ = ListHQAdapter(it, this)
            view.rv_fragment_list_HQ.adapter = adapterHQ
        })

        viewModel.getListHQs(offset)
        setScrollView(view)

        return view
    }

    override fun hqClick(position: Int) {
        viewModel.listComics.observe(this, {
            val selectHQ = it[position]

            val bundle = bundleOf("chave" to selectHQ)
            findNavController().navigate(R.id.action_fragmentListHQ_to_fragmentDetail, bundle)

        })
    }

    private fun setScrollView(view: View) {
        view.rv_fragment_list_HQ?.run {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    var itensTotal = adapterHQ.itemCount
                    var itensVisible = layoutManagerHQ.childCount
                    var itensPass = layoutManagerHQ.findFirstVisibleItemPosition()

                    if ((itensVisible + itensPass) == itensTotal) {
                        offset++
                        viewModel.getListHQs(offset)
                    }

                }
            })

        }

    }


}