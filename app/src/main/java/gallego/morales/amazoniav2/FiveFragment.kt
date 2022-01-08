package gallego.morales.amazoniav2

import android.annotation.SuppressLint
import android.content.Intent
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
    private var msn = ""
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
        val msn1 = Html.fromHtml(
            "<h2>Ticket</h2><body> <p>" + string + "</p></body>",
            Html.FROM_HTML_MODE_COMPACT
        )
        msn += msn1
        binding.resumeTiket.text = msn1
        string = asientos.toString().removePrefix("[")
        string = string.removeSuffix("]")
        string = string.replace(',', ' ')
        val msn2 = Html.fromHtml(
            "<body> <p>Asientos: " + string + "</p></body>",
            Html.FROM_HTML_MODE_COMPACT
        )
        msn += msn2
        binding.resumeTiketb.text = msn2
        val msn3 = Html.fromHtml(
            "<body><p>Total:" + solution.toString() + "</p></body>",
            Html.FROM_HTML_MODE_COMPACT
        )
        msn += msn3
        binding.resumeTiketc.text = msn3
        //binding.resumeTiket.text = complementos.toString()+"\nAsientos: "+asientos.toString()+"\nTotal: $solution"//funciona
        // """$complementos$asientos Total por los asientos$multipleAsientoPrecio Total por los complementos: $total"""
        binding.buttonFive.setOnClickListener {
            findNavController().navigate(R.id.action_fiveFragment_to_FirstFragment)
        }
        binding.imageButton.setOnClickListener {

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, msn)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
