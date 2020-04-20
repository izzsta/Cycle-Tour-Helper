package com.example.cycle_tour_helper.di;

import com.example.cycle_tour_helper.di.main.MainFragmentBuildersModule;
import com.example.cycle_tour_helper.ui.LoginActivity;
import com.example.cycle_tour_helper.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    //this is all that is needed to declare AuthActivity as a potential client
    //no annotations needed in the AuthActivity
    //when using @ContributesAndroidInjector, method and class must be abstract
    @ContributesAndroidInjector
            //adding modules here, to an activity module means the module is scoped to the life of that activity
            //only the AuthActivity sub-component can use these modules
            //we can inject attributes from AuthModule all over AuthViewModelsModule and AuthActivity

    public abstract LoginActivity contributeLoginActivity();


    @ContributesAndroidInjector(
            modules = {MainFragmentBuildersModule.class}

    )
    abstract MainActivity contributeMainActivity();

}
