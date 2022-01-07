package gallego.morales.amazoniav2

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import gallego.morales.amazoniav2.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var PRECIOBASE = 3.0f
    private var NOMBRECINE = ""

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSecond.setOnClickListener {
            val bundle = bundleOf("cineName" to NOMBRECINE, "sendedPrice" to PRECIOBASE)
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment, bundle)
        }
        binding.selectCineA.setOnClickListener {
            PRECIOBASE = 2.2f
            NOMBRECINE = binding.selectCineA.contentDescription as String
            "Ha seleccionado el cine: ${binding.selectCineA.contentDescription}"
        }
        binding.selectCineB.setOnClickListener {
            PRECIOBASE = 3.5f
            NOMBRECINE = binding.selectCineB.contentDescription as String
            binding.textviewSecond.text =
                """Ha seleccionado el cine: ${binding.selectCineB.contentDescription}"""
        }
        binding.selectCineC.setOnClickListener {
            PRECIOBASE = 3.0f
            NOMBRECINE = binding.selectCineC.contentDescription as String
            binding.textviewSecond.text =
                """Ha seleccionado el cine: """ + binding.selectCineC.contentDescription
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}