package gallego.morales.amazoniav2

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import gallego.morales.amazoniav2.databinding.FragmentThirdBinding



class ThirdFragment: Fragment() {


    private val PRIME_ZONE_PERCENT: Float = 0.40f
    private val ECONOMY_ZONE_PERCENT: Float = 0.10f
    private val STANDART_ZONE_PERCENT: Float = 0.20f
    private var percent: Float = 0.0f
    private var _binding: FragmentThirdBinding? = null
    private var precioCine: Float = 0.0f

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding.buttonThird.setOnClickListener {
            if (binding.textviewThird.text != "Seleccione la zona de su asiento") {
                val value = (precioCine + (precioCine * percent))
                Toast.makeText(activity, "Precio total $value", Toast.LENGTH_LONG).show()
                val bundle = bundleOf("Zone" to value)
                findNavController().navigate(R.id.action_thirdFragment_to_eightFragment, bundle)
            } else {
                Toast.makeText(
                    activity,
                    "Por favor seleccione una zona para su asiento",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        binding.button.setOnClickListener {
            binding.textviewThird.text = "La zona de su asiento es:\n Prime Zone"
            percent = PRIME_ZONE_PERCENT
        }
        binding.button2.setOnClickListener {
            binding.textviewThird.text = "La zona de su asiento es:\n Standart Zone"
            percent = STANDART_ZONE_PERCENT
        }
        binding.button3.setOnClickListener {

            percent = ECONOMY_ZONE_PERCENT
            binding.textviewThird.text = "La zona de su asiento es:\n Economy Zone"

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val precioCineEspecifico: Float? = arguments?.getFloat("sendedPrice")

        if (precioCineEspecifico != null) {
            precioCine = precioCineEspecifico
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}