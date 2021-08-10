package com.yangping.profiler

import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.yangping.profiler.cache.PluginPreferences
import com.yangping.profiler.controller.OkProfilerController
import com.yangping.profiler.form.OKProfiler

/**
 * @author yangping
 */
class OKProfilerWindowFactory : ToolWindowFactory,DumbAware {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        // init form
        val okProfiler = OKProfiler()
        // init cache
        val cache = PluginPreferences(PropertiesComponent.getInstance(project))
        // dispose form
        OkProfilerController(okProfiler,project,cache)
        // add form
        toolWindow.component.add(okProfiler.shell)
    }
}