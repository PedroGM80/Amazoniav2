package gallego.morales.amazoniav2


import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.util.Log.i
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import gallego.morales.amazoniav2.MainActivity.Companion.asientos
import gallego.morales.amazoniav2.MainActivity.Companion.complementos
import gallego.morales.amazoniav2.MainActivity.Companion.total
import gallego.morales.amazoniav2.databinding.FragmentEightBinding

class EightFragment : Fragment() {


    private var contador = 1
    private var precioPalomitas = 0.0
    private var totalComplemento = 0.0
    private var precioRefresco = 0.0
    private var refrescoTipo = ""
    private var refrescoSabor = ""
    private var selection: String = ""
    private var _binding: FragmentEightBinding? = null
    private val binding get() = _binding!!
    private var palomitas = ""

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
        binding.button17.setOnClickListener {
            totalComplemento = precioPalomitas + precioRefresco
            total += totalComplemento
            val id = binding.editTextTextPersonName.text.toString()
            //complementos[id] =" "
            complementos.add("Pedido nº:$contador de $id \n $palomitas$refrescoTipo$refrescoSabor\nTotal por complementos $totalComplemento")
            val foo = complementos.elementAtOrNull(contador)
            contador++
            Toast.makeText(activity, "Nombre: $foo", Toast.LENGTH_SHORT).show()
        }

        binding.radioButton.setOnClickListener {
            palomitas = " Palomitas con caramelo. "
            precioPalomitas = 2.1

        }
        binding.radioButton2.setOnClickListener {
            palomitas = " Palomitas con sal. "
            precioPalomitas = 1.1
        }
        binding.radioButton3.setOnClickListener {
            palomitas = " Palomitas con mantequilla. "
            precioPalomitas = 1.8
        }

        binding.radioButton1b.setOnClickListener {
            binding.RadioGroupRefrescoSabores.visibility = View.VISIBLE
            selection = "1"
            refrescoTipo = " Refresco light de"
            precioRefresco = 1.1
        }
        binding.radioButton2b.setOnClickListener {
            binding.RadioGroupRefrescoSabores.visibility = View.VISIBLE
            selection = "2"
            refrescoTipo = " Refresco zero de"
            precioRefresco = 1.2
        }
        binding.radioButton3b.setOnClickListener {
            binding.RadioGroupRefrescoSabores.visibility = View.VISIBLE
            selection = "3"
            refrescoTipo = " Refresco normal de"
            precioRefresco = 1.0
        }

        binding.radioButton1c.setOnClickListener {
            refrescoSabor = " cola."
        }

        binding.radioButton2c.setOnClickListener {
            refrescoSabor = " limón."
        }

        binding.radioButton3c.setOnClickListener {
            refrescoSabor = " naranja."
        }

        binding.buttonNext.setOnClickListener {
            if (binding.switch3.isChecked) {
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
            } else {
                val asiento: String
                var result = '#'
                val num = (1..11).random()
                val zonaCine: String? = arguments?.getString("zoneName")
                if (zonaCine == "prime") {
                    result = ('H'..'K').shuffled().last()
                }
                if (zonaCine == "standard") {
                    result = ('D'..'G').shuffled().last()
                }
                if (zonaCine == "economy") {
                    result = ('A'..'C').shuffled().last()
                }

                asiento = "" + result + num
                //totalComplemento = precioPalomitas + precioRefresco
                val precioCineAsiento: Double? = arguments?.getDouble("PrecioAsiento")
                total += precioCineAsiento!!
                val resume = "$total $asiento"
                Log.d("@miTag", resume)
                asientos.add(
                    contador - 1,
                    "\nAsiento ref:" + asiento + "\nCon precio: " + precioCineAsiento.toString()
                )
                //val bundle = bundleOf("PrecioTotal" to value)
                findNavController().navigate(R.id.action_eightFragment_to_fiveFragment)
            }
        }
    }
}



