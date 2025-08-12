package modules

object FeatureModules {
    private const val ROOT_PATH = ":feature"

    object Home {
        private const val PATH = "$ROOT_PATH:home"
        const val Data = "$PATH:data"
        const val Domain = "$PATH:domain"
        const val Presentation = "$PATH:presentation"
    }
}
