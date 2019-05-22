package com.tokoonline.ban.onlineshop;


import com.tokoonline.ban.onlineshop.Fragment.Base.BaseFragment;

public interface MainView {
    void attachHomeFragment(BaseFragment currentFragment, BaseFragment fragment);
    void attachProfileFragment(BaseFragment currentFragment, BaseFragment fragment);
    void attachPromoFragment(BaseFragment currentFragment, BaseFragment fragment);
}
