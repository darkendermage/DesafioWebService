package br.com.digitalhouse.desafio3_webservices.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import br.com.digitalhouse.desafio3_webservices.R
import br.com.digitalhouse.desafio3_webservices.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.view.*

class FragmentDetail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val picasso = Picasso.get()
        getImage(picasso, view)
        val hqDetail = getObjetoHQ()

        showDetailHQ(hqDetail, view, picasso)
        openImage(hqDetail, view)
        backListHQ(view)

        return view
    }


    private fun backListHQ(view: View) {
        view.toolbar_fragDetail.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_fragmentDetail_to_fragmentListHQ)
        }
    }

    private fun openImage(hqDetail: Result, view: View) {
        val bundle = bundleOf("chave" to hqDetail)
        view.iv_capa_fragmentDetails.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragmentDetail_to_fragmentImageHQ, bundle
            )
        }
    }

    private fun showDetailHQ(
        hqDetail: Result,
        view: View,
        picasso: Picasso
    ) {
        view.tv_titulo_fragDetail.text = hqDetail.title
        view.tv_descricao_fragDetail.text = hqDetail.description
        view.tv_price_fragDetail.text = hqDetail.prices[0].price
        view.tv_pages_fragDetail.text = hqDetail.pageCount.toString()
        view.tv_published_fragDetail.text = hqDetail.dates[0].date

        picasso.load(hqDetail.thumbnail.path.replace("http://", "https://")
                +"."+ hqDetail.thumbnail.extension).into(view.iv_capa_fragmentDetails)
    }

    private fun getObjetoHQ(): Result {
        return arguments?.get("chave") as Result
    }

    private fun getImage(picasso: Picasso, view: View) {
        picasso.load(
            "https://i.annihil.us/u/prod/marvel/i/mg/3/50/526548a343e4b"
                    + "/landscape_large."
                    + "jpg"
        ).into(view.iv_fragDetail)
    }
}