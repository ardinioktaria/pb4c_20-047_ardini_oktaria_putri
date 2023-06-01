package com.example.tugaspratikum6

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private var list = mutableListOf<User>()
    private lateinit var adapter: UserAdapter
    private lateinit var database: AppDatabase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = rootView.findViewById(R.id.recycler_view)
        fab = rootView.findViewById(R.id.floating_btn)

        database = AppDatabase.getInstance(requireContext())
        adapter = UserAdapter(list)
        adapter.setDialog(object : UserAdapter.Dialog{
            override fun onClick(position: Int) {
                // Membuat dialog view
                val dialog = AlertDialog.Builder(requireContext())
                dialog.setTitle(list[position].fullName)
                dialog.setItems(R.array.items_option, DialogInterface.OnClickListener{ dialog, which ->
                    if (which==0){
                        // coding ubah
                        val editFragment = EditFragment()
                        val bundle = Bundle()
                        bundle.putInt("id", list[position])
                        editFragment.arguments = bundle

                        val fragmentManager = requireActivity().supportFragmentManager
                        val fragmentTransaction = fragmentManager.beginTransaction()
                        fragmentTransaction.replace(R.id.frame_container, editFragment)
                        fragmentTransaction.addToBackStack(null)
                        fragmentTransaction.commit()

                    }
                    else if (which==1){
                        // coding hapus
                        database.userDao().delete(list[position])
                        getData()
                    }
                    else{
                        // coding batal
                        dialog.dismiss()
                    }
                })
                // Menampilkan dialog
                val dialogView = dialog.create()
                dialogView.show()
            }
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))

        fab.setOnClickListener {
            val editFragment = EditFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_container, editFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }


        return rootView
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    private fun getData() {
        list.clear()
        list.addAll(database.userDao().getAll())
        adapter.notifyDataSetChanged()
    }
}

private fun Bundle.putInt(s: String, user: User) {

}