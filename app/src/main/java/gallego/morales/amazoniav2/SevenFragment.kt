package gallego.morales.amazoniav2

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class SevenFragment : Fragment() {
    private var _binding: gallego.morales.amazoniav2.databinding.FragmentSevenBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        _binding = gallego.morales.amazoniav2.databinding.FragmentSevenBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val price: Float? = arguments?.getFloat("Zone")
        Toast.makeText(activity, "Test$price", Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.next4?.setOnClickListener {
            findNavController().navigate(R.id.action_sevenFragment_to_fiveFragment)
        }
    }

}
