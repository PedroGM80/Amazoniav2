package gallego.morales.amazoniav2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import gallego.morales.amazoniav2.databinding.FragmentThirdBinding



/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment: Fragment() {

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonThird.setOnClickListener {
            val pago=(0 until 4).random()//genero un número aleatorio entre 0 y 4
            if (pago==1){
                findNavController().navigate(R.id.action_thirdFragment_to_fifthFragment)//utilizo el 1 para ir a el 5 fragmentoto
            }else{
                findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)//el resto ira al cuarto fragmento
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}