package gallego.morales.amazoniav2

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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            val bundle = bundleOf("sendedPrice" to PRECIOBASE)
            findNavController().navigate(R.id.action_SecondFragment_to_thirdFragment, bundle)
        }
        binding.selectCineA.setOnClickListener {
            PRECIOBASE = 2.2f
            binding.textviewSecond.text =
                "Ha seleccionado el cine: " + binding.selectCineA.contentDescription.toString()
        }
        binding.selectCineB.setOnClickListener {
            PRECIOBASE = 3.5f
            binding.textviewSecond.text =
                "Ha seleccionado el cine: " + binding.selectCineB.contentDescription.toString()
        }
        binding.selectCineC.setOnClickListener {
            PRECIOBASE = 3.0f
            binding.textviewSecond.text =
                "Ha seleccionado el cine: " + binding.selectCineC.contentDescription.toString()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}