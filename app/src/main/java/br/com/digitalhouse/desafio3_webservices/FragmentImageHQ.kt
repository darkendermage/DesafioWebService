package br.com.digitalhouse.desafio3_webservices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import br.com.digitalhouse.desafio3_webservices.comicsHQ.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_image_h_q.view.*

class FragmentImageHQ : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image_h_q, container, false)
        val picasso = Picasso.get()
        val showHQ = imgScreen(picasso, view)

        backDetailsHQ(showHQ, view)

        return view
    }

    private fun imgScreen(
        picasso: Picasso,
        view: View
    ): Result {
        val mostraHQ = arguments?.get("chave") as Result

        val hqExibidoPath = mostraHQ.thumbnail.path
        val hqExibidoExt = mostraHQ.thumbnail.extension
        val imageHq = "/portrait_incredible."
        val urlObj = hqExibidoPath + imageHq + hqExibidoExt

        picasso.load(urlObj).into(view.iv_fragImage)
        return mostraHQ
    }

    private fun backDetailsHQ(hqImg: Result, view: View) {
        val bundleVolta = bundleOf("chave" to hqImg)
        view.toolbar_fragImageHQ.setNavigationOnClickListener {
            findNavController().navigate(
                R.id.action_fragmentImageHQ_to_fragmentDetail,
                bundleVolta
            )
        }
    }
}