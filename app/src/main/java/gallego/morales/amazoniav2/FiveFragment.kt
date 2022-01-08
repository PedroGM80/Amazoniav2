package gallego.morales.amazoniav2

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import gallego.morales.amazoniav2.MainActivity.Companion.asientos
import gallego.morales.amazoniav2.MainActivity.Companion.complementos
import gallego.morales.amazoniav2.MainActivity.Companion.total
import gallego.morales.amazoniav2.databinding.FragmentFiveBinding


class FiveFragment : Fragment() {

    private var _binding: FragmentFiveBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        _binding = FragmentFiveBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  val precioAsiento:Float? = arguments?.getFloat("PrecioAsiento")
        // val multipleAsientoPrecio = precioAsiento * asientos.size
        var string = complementos.toString().removePrefix("[")
        string = string.removeSuffix("]")
        string = string.replace(',', ' ')

        val solution: Double = String.format("%.2f", total).toDouble()
        binding.resumeTiket.text = Html.fromHtml(
            "<h2>Ticket</h2><body> <p>" + string + "</p></body>",
            Html.FROM_HTML_MODE_COMPACT
        )
        string = asientos.toString().removePrefix("[")
        string = string.removeSuffix("]")
        string = string.replace(',', ' ')
        binding.resumeTiketb.text = Html.fromHtml(
            "<body> <p>Asientos: " + string + "</p></body>",
            Html.FROM_HTML_MODE_COMPACT
        )
        binding.resumeTiketc.text = Html.fromHtml(
            "<body><p>Total:" + solution.toString() + "</p></body>",
            Html.FROM_HTML_MODE_COMPACT
        )
        //binding.resumeTiket.text = complementos.toString()+"\nAsientos: "+asientos.toString()+"\nTotal: $solution"//funciona
        // """$complementos$asientos Total por los asientos$multipleAsientoPrecio Total por los complementos: $total"""
        binding.buttonFive.setOnClickListener {
            findNavController().navigate(R.id.action_fiveFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
