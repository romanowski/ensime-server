import sbt._
import Keys._
import sbt.plugins.CorePlugin
import sbt.plugins.JvmPlugin
import org.romanowski.hoarder.actions.CachedCI

object PreventCompilation extends AutoPlugin {

  // so we can rewrite default tasks, e.g. compile
  override def requires: Plugins = CorePlugin && JvmPlugin

  def perConfig = Seq(
    manipulateBytecode := {
      val res = manipulateBytecode.value
      if (res.hasModified && CachedCI.currentSetup.value.shouldUseCache())
        throw new RuntimeException(s"Compilation wasn't no-op after import for ${name.value}")
      res
    }
  )

  override def trigger: PluginTrigger = AllRequirements

  override def projectSettings: Seq[Setting[_]] ={
    inConfig(Compile)(perConfig) ++ inConfig(Test)(perConfig)
  }
}