package gallego.morales.amazoniav2

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log.i
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import gallego.morales.amazoniav2.databinding.FragmentEightBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class EightFragment : Fragment() {

    private var selection: String = ""
    private var _binding: FragmentEightBinding? = null
    private val binding get() = _binding!!


    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        _binding = FragmentEightBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //val nombreCine:String?=arguments?.getString("Zone")
        super.onViewCreated(view, savedInstanceState)
        binding.switch1.setOnClickListener {
            if (this.binding.switch1.isChecked) {
                i(":::Mi tag", "switch1")
                binding.radioGroupPalomitas.visibility = View.VISIBLE
            } else {
                binding.radioGroupPalomitas.visibility = View.INVISIBLE
            }
        }
        binding.switch2.setOnClickListener {
            if (this.binding.switch2.isChecked) {
                i(":::Mi tag", "switch2")
                binding.RadioGroupRefresco.visibility = View.VISIBLE
                if (selection != "") {
                    binding.RadioGroupRefrescoSabores.visibility = View.VISIBLE
                }
            } else {
                binding.RadioGroupRefresco.visibility = View.INVISIBLE
                binding.RadioGroupRefrescoSabores.visibility = View.INVISIBLE
            }
        }

        binding.radioButton1b.setOnClickListener {
            binding.RadioGroupRefrescoSabores.visibility = View.VISIBLE
            selection = "1"
        }
        binding.radioButton2b.setOnClickListener {
            binding.RadioGroupRefrescoSabores.visibility = View.VISIBLE
            selection = "2"
        }
        binding.radioButton3b.setOnClickListener {
            binding.RadioGroupRefrescoSabores.visibility = View.VISIBLE
            selection = "3"
        }
        binding.buttonNext.setOnClickListener {
            val zonaCine: String? = arguments?.getString("zoneName")
            Toast.makeText(activity, zonaCine, Toast.LENGTH_LONG).show()
            if (zonaCine == "prime") {
                findNavController().navigate(R.id.action_eightFragment_to_fourFragment)
            }
            if (zonaCine == "standard") {
                findNavController().navigate(R.id.action_eightFragment_to_sixFragment)
            }
            if (zonaCine == "economy") {
                findNavController().navigate(R.id.action_eightFragment_to_sevenFragment)
            }
        }
    }
}



