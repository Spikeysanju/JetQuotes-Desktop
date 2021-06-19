package dev.spikeysanju.jetquotes.view.splash;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dev.spikeysanju.jetquotes.viewmodel.MainViewModel;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SplashScreenComponent_MembersInjector implements MembersInjector<SplashScreenComponent> {
  private final Provider<MainViewModel> viewModelProvider;

  public SplashScreenComponent_MembersInjector(Provider<MainViewModel> viewModelProvider) {
    this.viewModelProvider = viewModelProvider;
  }

  public static MembersInjector<SplashScreenComponent> create(
      Provider<MainViewModel> viewModelProvider) {
    return new SplashScreenComponent_MembersInjector(viewModelProvider);
  }

  @Override
  public void injectMembers(SplashScreenComponent instance) {
    injectViewModel(instance, viewModelProvider.get());
  }

  @InjectedFieldSignature("dev.spikeysanju.jetquotes.view.splash.SplashScreenComponent.viewModel")
  public static void injectViewModel(SplashScreenComponent instance, MainViewModel viewModel) {
    instance.viewModel = viewModel;
  }
}
