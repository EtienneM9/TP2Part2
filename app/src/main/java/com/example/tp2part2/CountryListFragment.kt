package com.example.tp2part2
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CountryListFragment : BottomSheetDialogFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var searchView: SearchView
    private lateinit var countries: List<Country>
    private lateinit var filteredCountries: MutableList<Country>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_country_list, container, false)

        recyclerView = view.findViewById(R.id.countryRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        searchView = view.findViewById(R.id.countrySearchView)


        // data en dur
        countries = listOf(
            // France en premier par chauvinisme
            Country("France", "Paris", "Europe", "https://flagcdn.com/h60/fr.png"),

            // Les grandes puissances économiques (ajustées après France)
            Country("United States", "Washington, D.C.", "North America", "https://flagcdn.com/h60/us.png"),
            Country("China", "Beijing", "Asia", "https://flagcdn.com/h60/cn.png"),
            Country("Japan", "Tokyo", "Asia", "https://flagcdn.com/h60/jp.png"),
            Country("Germany", "Berlin", "Europe", "https://flagcdn.com/h60/de.png"),
            Country("India", "New Delhi", "Asia", "https://flagcdn.com/h60/in.png"),
            Country("United Kingdom", "London", "Europe", "https://flagcdn.com/h60/gb.png"),
            Country("Italy", "Rome", "Europe", "https://flagcdn.com/h60/it.png"),
            Country("Canada", "Ottawa", "North America", "https://flagcdn.com/h60/ca.png"),
            Country("South Korea", "Seoul", "Asia", "https://flagcdn.com/h60/kr.png"),
            Country("Russia", "Moscow", "Europe", "https://flagcdn.com/h60/ru.png"),
            Country("Brazil", "Brasília", "South America", "https://flagcdn.com/h60/br.png"),
            Country("Australia", "Canberra", "Oceania", "https://flagcdn.com/h60/au.png"),
            Country("Spain", "Madrid", "Europe", "https://flagcdn.com/h60/es.png"),
            Country("Mexico", "Mexico City", "North America", "https://flagcdn.com/h60/mx.png"),
            Country("Indonesia", "Jakarta", "Asia", "https://flagcdn.com/h60/id.png"),
            Country("Netherlands", "Amsterdam", "Europe", "https://flagcdn.com/h60/nl.png"),
            Country("Saudi Arabia", "Riyadh", "Asia", "https://flagcdn.com/h60/sa.png"),
            Country("Turkey", "Ankara", "Asia", "https://flagcdn.com/h60/tr.png"),
            Country("Switzerland", "Bern", "Europe", "https://flagcdn.com/h60/ch.png"),
            Country("Poland", "Warsaw", "Europe", "https://flagcdn.com/h60/pl.png"),
            Country("Sweden", "Stockholm", "Europe", "https://flagcdn.com/h60/se.png"),
            Country("Belgium", "Brussels", "Europe", "https://flagcdn.com/h60/be.png"),
            Country("Argentina", "Buenos Aires", "South America", "https://flagcdn.com/h60/ar.png"),
            Country("Norway", "Oslo", "Europe", "https://flagcdn.com/h60/no.png"),
            Country("Austria", "Vienna", "Europe", "https://flagcdn.com/h60/at.png"),
            Country("United Arab Emirates", "Abu Dhabi", "Asia", "https://flagcdn.com/h60/ae.png"),
            Country("Iran", "Tehran", "Asia", "https://flagcdn.com/h60/ir.png"),
            Country("Thailand", "Bangkok", "Asia", "https://flagcdn.com/h60/th.png"),
            Country("Nigeria", "Abuja", "Africa", "https://flagcdn.com/h60/ng.png"),
            Country("Egypt", "Cairo", "Africa", "https://flagcdn.com/h60/eg.png"),
            Country("Denmark", "Copenhagen", "Europe", "https://flagcdn.com/h60/dk.png"),
            Country("Singapore", "Singapore", "Asia", "https://flagcdn.com/h60/sg.png"),
            Country("South Africa", "Pretoria", "Africa", "https://flagcdn.com/h60/za.png"),
            Country("Malaysia", "Kuala Lumpur", "Asia", "https://flagcdn.com/h60/my.png"),
            Country("Colombia", "Bogotá", "South America", "https://flagcdn.com/h60/co.png"),
            Country("Philippines", "Manila", "Asia", "https://flagcdn.com/h60/ph.png"),
            Country("Pakistan", "Islamabad", "Asia", "https://flagcdn.com/h60/pk.png"),
            Country("Chile", "Santiago", "South America", "https://flagcdn.com/h60/cl.png"),
            Country("Finland", "Helsinki", "Europe", "https://flagcdn.com/h60/fi.png"),
            Country("Bangladesh", "Dhaka", "Asia", "https://flagcdn.com/h60/bd.png"),
            Country("Vietnam", "Hanoi", "Asia", "https://flagcdn.com/h60/vn.png"),
            Country("Czech Republic", "Prague", "Europe", "https://flagcdn.com/h60/cz.png"),
            Country("Romania", "Bucharest", "Europe", "https://flagcdn.com/h60/ro.png"),
            Country("Peru", "Lima", "South America", "https://flagcdn.com/h60/pe.png"),
            Country("New Zealand", "Wellington", "Oceania", "https://flagcdn.com/h60/nz.png"),
            Country("Qatar", "Doha", "Asia", "https://flagcdn.com/h60/qa.png"),
            Country("Algeria", "Algiers", "Africa", "https://flagcdn.com/h60/dz.png"),
            Country("Iraq", "Baghdad", "Asia", "https://flagcdn.com/h60/iq.png"),
            Country("Kazakhstan", "Astana", "Asia", "https://flagcdn.com/h60/kz.png"),
            Country("Hungary", "Budapest", "Europe", "https://flagcdn.com/h60/hu.png"),
            Country("Morocco", "Rabat", "Africa", "https://flagcdn.com/h60/ma.png"),
            Country("Kuwait", "Kuwait City", "Asia", "https://flagcdn.com/h60/kw.png"),
            Country("Ukraine", "Kyiv", "Europe", "https://flagcdn.com/h60/ua.png"),
            Country("Angola", "Luanda", "Africa", "https://flagcdn.com/h60/ao.png"),
            Country("Ecuador", "Quito", "South America", "https://flagcdn.com/h60/ec.png"),
            Country("Slovakia", "Bratislava", "Europe", "https://flagcdn.com/h60/sk.png"),
            Country("Portugal", "Lisbon", "Europe", "https://flagcdn.com/h60/pt.png"),
            Country("Cuba", "Havana", "North America", "https://flagcdn.com/h60/cu.png"),
            Country("Greece", "Athens", "Europe", "https://flagcdn.com/h60/gr.png"),
            Country("Oman", "Muscat", "Asia", "https://flagcdn.com/h60/om.png"),
            Country("Kenya", "Nairobi", "Africa", "https://flagcdn.com/h60/ke.png"),
            Country("Dominican Republic", "Santo Domingo", "North America", "https://flagcdn.com/h60/do.png"),
            Country("Ethiopia", "Addis Ababa", "Africa", "https://flagcdn.com/h60/et.png"),
            Country("Guatemala", "Guatemala City", "North America", "https://flagcdn.com/h60/gt.png"),
            Country("Luxembourg", "Luxembourg City", "Europe", "https://flagcdn.com/h60/lu.png"),
            Country("Ghana", "Accra", "Africa", "https://flagcdn.com/h60/gh.png"),
            Country("Bulgaria", "Sofia", "Europe", "https://flagcdn.com/h60/bg.png"),
            Country("Croatia", "Zagreb", "Europe", "https://flagcdn.com/h60/hr.png"),
            Country("Panama", "Panama City", "North America", "https://flagcdn.com/h60/pa.png"),
            Country("Costa Rica", "San José", "North America", "https://flagcdn.com/h60/cr.png"),
            Country("Ivory Coast", "Yamoussoukro", "Africa", "https://flagcdn.com/h60/ci.png"),
            Country("Uruguay", "Montevideo", "South America", "https://flagcdn.com/h60/uy.png"),
            Country("Belarus", "Minsk", "Europe", "https://flagcdn.com/h60/by.png"),
            Country("Lithuania", "Vilnius", "Europe", "https://flagcdn.com/h60/lt.png"),
            Country("Serbia", "Belgrade", "Europe", "https://flagcdn.com/h60/rs.png"),
            Country("Slovenia", "Ljubljana", "Europe", "https://flagcdn.com/h60/si.png"),
            Country("Myanmar", "Naypyidaw", "Asia", "https://flagcdn.com/h60/mm.png"),
            Country("Democratic Republic of the Congo", "Kinshasa", "Africa", "https://flagcdn.com/h60/cd.png"),
            Country("Sudan", "Khartoum", "Africa", "https://flagcdn.com/h60/sd.png"),
            Country("Uzbekistan", "Tashkent", "Asia", "https://flagcdn.com/h60/uz.png"),
            Country("Tunisia", "Tunis", "Africa", "https://flagcdn.com/h60/tn.png"),
            Country("Uganda", "Kampala", "Africa", "https://flagcdn.com/h60/ug.png"),
            Country("Jordan", "Amman", "Asia", "https://flagcdn.com/h60/jo.png"),
            Country("Libya", "Tripoli", "Africa", "https://flagcdn.com/h60/ly.png"),
            Country("Turkmenistan", "Ashgabat", "Asia", "https://flagcdn.com/h60/tm.png"),
            Country("Bolivia", "Sucre", "South America", "https://flagcdn.com/h60/bo.png"),
            Country("Paraguay", "Asunción", "South America", "https://flagcdn.com/h60/py.png"),
            Country("Latvia", "Riga", "Europe", "https://flagcdn.com/h60/lv.png"),
            Country("Bahrain", "Manama", "Asia", "https://flagcdn.com/h60/bh.png"),
            Country("Estonia", "Tallinn", "Europe", "https://flagcdn.com/h60/ee.png"),
            Country("Nepal", "Kathmandu", "Asia", "https://flagcdn.com/h60/np.png"),
            Country("Cameroon", "Yaoundé", "Africa", "https://flagcdn.com/h60/cm.png"),
            Country("El Salvador", "San Salvador", "North America", "https://flagcdn.com/h60/sv.png"),
            Country("Honduras", "Tegucigalpa", "North America", "https://flagcdn.com/h60/hn.png"),
            Country("Papua New Guinea", "Port Moresby", "Oceania", "https://flagcdn.com/h60/pg.png"),
            Country("Cambodia", "Phnom Penh", "Asia", "https://flagcdn.com/h60/kh.png"),
            Country("Zambia", "Lusaka", "Africa", "https://flagcdn.com/h60/zm.png"),
            Country("Cyprus", "Nicosia", "Europe", "https://flagcdn.com/h60/cy.png"),
            Country("Iceland", "Reykjavík", "Europe", "https://flagcdn.com/h60/is.png"),
            Country("Trinidad and Tobago", "Port of Spain", "North America", "https://flagcdn.com/h60/tt.png"),
            Country("Senegal", "Dakar", "Africa", "https://flagcdn.com/h60/sn.png"),
            Country("Zimbabwe", "Harare", "Africa", "https://flagcdn.com/h60/zw.png"),
            Country("Bosnia and Herzegovina", "Sarajevo", "Europe", "https://flagcdn.com/h60/ba.png"),
            Country("Georgia", "Tbilisi", "Asia", "https://flagcdn.com/h60/ge.png"),
            Country("Laos", "Vientiane", "Asia", "https://flagcdn.com/h60/la.png"),
            Country("Equatorial Guinea", "Malabo", "Africa", "https://flagcdn.com/h60/gq.png"),
            Country("Guinea", "Conakry", "Africa", "https://flagcdn.com/h60/gn.png"),
            Country("Gabon", "Libreville", "Africa", "https://flagcdn.com/h60/ga.png"),
            Country("Botswana", "Gaborone", "Africa", "https://flagcdn.com/h60/bw.png"),
            Country("North Macedonia", "Skopje", "Europe", "https://flagcdn.com/h60/mk.png"),
            Country("Jamaica", "Kingston", "North America", "https://flagcdn.com/h60/jm.png"),
            Country("Albania", "Tirana", "Europe", "https://flagcdn.com/h60/al.png"),
            Country("Armenia", "Yerevan", "Asia", "https://flagcdn.com/h60/am.png"),
            Country("Mozambique", "Maputo", "Africa", "https://flagcdn.com/h60/mz.png"),
            Country("Malta", "Valletta", "Europe", "https://flagcdn.com/h60/mt.png"),
            Country("Namibia", "Windhoek", "Africa", "https://flagcdn.com/h60/na.png"),
            Country("Mongolia", "Ulaanbaatar", "Asia", "https://flagcdn.com/h60/mn.png"),
            Country("Brunei", "Bandar Seri Begawan", "Asia", "https://flagcdn.com/h60/bn.png"),
            Country("Mali", "Bamako", "Africa", "https://flagcdn.com/h60/ml.png"),
            Country("Madagascar", "Antananarivo", "Africa", "https://flagcdn.com/h60/mg.png"),
            Country("Nicaragua", "Managua", "North America", "https://flagcdn.com/h60/ni.png"),
            Country("Congo", "Brazzaville", "Africa", "https://flagcdn.com/h60/cg.png"),
            Country("Mauritius", "Port Louis", "Africa", "https://flagcdn.com/h60/mu.png"),
            Country("Burkina Faso", "Ouagadougou", "Africa", "https://flagcdn.com/h60/bf.png"),
            Country("Chad", "N'Djamena", "Africa", "https://flagcdn.com/h60/td.png"),
            Country("Bahamas", "Nassau", "North America", "https://flagcdn.com/h60/bs.png"),
            Country("Rwanda", "Kigali", "Africa", "https://flagcdn.com/h60/rw.png"),
            Country("Moldova", "Chișinău", "Europe", "https://flagcdn.com/h60/md.png"),
            Country("Benin", "Porto-Novo", "Africa", "https://flagcdn.com/h60/bj.png"),
            Country("Haiti", "Port-au-Prince", "North America", "https://flagcdn.com/h60/ht.png"),
            Country("Malawi", "Lilongwe", "Africa", "https://flagcdn.com/h60/mw.png"),
            Country("Tajikistan", "Dushanbe", "Asia", "https://flagcdn.com/h60/tj.png"),
            Country("Kosovo", "Pristina", "Europe", "https://flagcdn.com/h60/xk.png"),
            Country("Togo", "Lomé", "Africa", "https://flagcdn.com/h60/tg.png"),
            Country("Kyrgyzstan", "Bishkek", "Asia", "https://flagcdn.com/h60/kg.png"),
            Country("Mauritania", "Nouakchott", "Africa", "https://flagcdn.com/h60/mr.png"),
            Country("Guyana", "Georgetown", "South America", "https://flagcdn.com/h60/gy.png"),
            Country("Lesotho", "Maseru", "Africa", "https://flagcdn.com/h60/ls.png"),
            Country("Suriname", "Paramaribo", "South America", "https://flagcdn.com/h60/sr.png"),
            Country("Maldives", "Malé", "Asia", "https://flagcdn.com/h60/mv.png"),
            Country("Montenegro", "Podgorica", "Europe", "https://flagcdn.com/h60/me.png"),
            Country("Sierra Leone", "Freetown", "Africa", "https://flagcdn.com/h60/sl.png"),
            Country("Barbados", "Bridgetown", "North America", "https://flagcdn.com/h60/bb.png"),
            Country("Fiji", "Suva", "Oceania", "https://flagcdn.com/h60/fj.png"),
            Country("Eswatini", "Mbabane", "Africa", "https://flagcdn.com/h60/sz.png"),
            Country("Djibouti", "Djibouti", "Africa", "https://flagcdn.com/h60/dj.png"),
            Country("Liberia", "Monrovia", "Africa", "https://flagcdn.com/h60/lr.png"),
            Country("Bhutan", "Thimphu", "Asia", "https://flagcdn.com/h60/bt.png"),
            Country("Cape Verde", "Praia", "Africa", "https://flagcdn.com/h60/cv.png"),
            Country("Belize", "Belmopan", "North America", "https://flagcdn.com/h60/bz.png"),
            Country("Gambia", "Banjul", "Africa", "https://flagcdn.com/h60/gm.png"),
            Country("Seychelles", "Victoria", "Africa", "https://flagcdn.com/h60/sc.png"),
            Country("Antigua and Barbuda", "Saint John's", "North America", "https://flagcdn.com/h60/ag.png"),
            Country("Andorra", "Andorra la Vella", "Europe", "https://flagcdn.com/h60/ad.png"),
            Country("Timor-Leste", "Dili", "Asia", "https://flagcdn.com/h60/tl.png"),
            Country("Saint Lucia", "Castries", "North America", "https://flagcdn.com/h60/lc.png"),
            Country("Burundi", "Gitega", "Africa", "https://flagcdn.com/h60/bi.png"),
            Country("Grenada", "Saint George's", "North America", "https://flagcdn.com/h60/gd.png"),
            Country("Saint Vincent and the Grenadines", "Kingstown", "North America", "https://flagcdn.com/h60/vc.png"),
            Country("Solomon Islands", "Honiara", "Oceania", "https://flagcdn.com/h60/sb.png"),
            Country("Samoa", "Apia", "Oceania", "https://flagcdn.com/h60/ws.png"),
            Country("Vanuatu", "Port Vila", "Oceania", "https://flagcdn.com/h60/vu.png"),
            Country("Saint Kitts and Nevis", "Basseterre", "North America", "https://flagcdn.com/h60/kn.png"),
            Country("Tonga", "Nuku'alofa", "Oceania", "https://flagcdn.com/h60/to.png"),
            Country("Comoros", "Moroni", "Africa", "https://flagcdn.com/h60/km.png"),
            Country("Dominica", "Roseau", "North America", "https://flagcdn.com/h60/dm.png"),
            Country("Sao Tome and Principe", "São Tomé", "Africa", "https://flagcdn.com/h60/st.png"),
            Country("Micronesia", "Palikir", "Oceania", "https://flagcdn.com/h60/fm.png"),
            Country("Palau", "Ngerulmud", "Oceania", "https://flagcdn.com/h60/pw.png"),
            Country("Marshall Islands", "Majuro", "Oceania", "https://flagcdn.com/h60/mh.png"),
            Country("Kiribati", "Tarawa", "Oceania", "https://flagcdn.com/h60/ki.png"),
            Country("Tuvalu", "Funafuti", "Oceania", "https://flagcdn.com/h60/tv.png"),
            Country("Nauru", "Yaren", "Oceania", "https://flagcdn.com/h60/nr.png")
        )

        filteredCountries = countries.toMutableList()


        countryAdapter = CountryAdapter(countries) { selectedCountry ->
            Log.d("CountryListFragment", "Selected country: $selectedCountry")
            // Open CountryDetailFragment
            val countryDetailBottomSheetFragment = CountryDetailFragment.newInstance(selectedCountry)
            countryDetailBottomSheetFragment.show(parentFragmentManager, "CountryDetailBottomSheetFragment")
            dismiss()
        }
        recyclerView.adapter = countryAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterCountries(newText)
                return true
            }
        })

        return view
    }

    private fun filterCountries(query: String?) {
        filteredCountries.clear()
        if (query.isNullOrBlank()) {
            filteredCountries.addAll(countries)
        } else {
            val lowerCaseQuery = query.lowercase()
            for (country in countries) {
                if (country.name.lowercase().contains(lowerCaseQuery)) {
                    filteredCountries.add(country)
                }
            }
        }
        countryAdapter.notifyDataSetChanged()
    }
}