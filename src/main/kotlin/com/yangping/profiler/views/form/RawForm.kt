/**
 * Copyright 2018 LocaleBro.com [Ievgenii Tkachenko(gektor650@gmail.com)]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yangping.profiler.views.form

import com.yangping.profiler.views.FrameScrollPanel
import javax.swing.JTextPane

class RawForm  {
    private val editor = JTextPane()
    val panel = FrameScrollPanel(editor)

    init {
        editor.isEditable = false
        editor.text = ""
        editor.caretPosition = 0
    }

    fun setText(data: String?) {
        editor.text = data
        editor.caretPosition = 0
    }
}
