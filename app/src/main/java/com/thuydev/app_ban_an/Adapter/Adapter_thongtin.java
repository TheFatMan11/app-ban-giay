package com.thuydev.app_ban_an.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.thuydev.app_ban_an.frm.Fragment_khoanchi;
import com.thuydev.app_ban_an.frm.Fragment_thongtin;


public class Adapter_thongtin extends FragmentStateAdapter {
    int i = 2;
    Fragment_thongtin fragmentThongtin;
    Fragment_khoanchi fragmentKhoanchi;

    public Adapter_thongtin(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        fragmentThongtin = new Fragment_thongtin();
        fragmentKhoanchi = new Fragment_khoanchi();
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {

            return fragmentThongtin;
        } else {
            return fragmentKhoanchi;
        }
    }

    @Override
    public int getItemCount() {
        return i;
    }


}
