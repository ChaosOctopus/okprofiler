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
package com.yangping.profiler.data.generation.printer

import com.yangping.profiler.data.generation.ObjectClassModel
import com.yangping.profiler.data.generation.FieldModel
import com.yangping.profiler.data.generation.FieldType

class KotlinModelPrinter(private val classModels: List<ObjectClassModel>) : BaseClassModelPrinter() {

    override fun addField(field: FieldModel) {
        addSerializationAnnotation(field.originName)
        builder.append(
                TABULATION,
                VAL_CONST
        )
        builder.append(
                field.name,
                VAL_DELIMITER
        )
        when {
            field.type == FieldType.LIST -> {
                builder.append(FieldType.LIST.kotlin)
                builder.append(GENERIC_START)
                if (field.typeObjectName != null) {
                    builder.append(field.typeObjectName)
                } else {
                    builder.append(field.genericType?.kotlin)
                }
                builder.append(GENERIC_END)
            }
            field.typeObjectName != null -> builder.append(field.typeObjectName)
            else -> builder.append(field.type.kotlin)
        }
    }

    override fun getListType(field: FieldModel): String {
        if(field.genericType != null) {
            return field.genericType.kotlin
        }
        return field.type.kotlin
    }

    override fun build(): StringBuilder {
        addImport()
        classModels.forEach { classModel ->
            if (classModel.fields.isEmpty()) {
                builder.append(CLASS_NAME)
                builder.append(classModel.name)
                builder.append(LINE_BREAK)
                builder.append(TODO_NULLABLE)
                builder.append(LINE_BREAK)
                builder.append(LINE_BREAK)
            } else {
                builder.append(DATA_CLASS)
                builder.append(CLASS_NAME)
                builder.append(classModel.name)
                builder.append(ARG_START)
                builder.append(LINE_BREAK)
                classModel.fields.forEachIndexed { index, field ->
                    addField(field)
                    if (index != classModel.fields.size - 1) {
                        builder.append(ARG_DELIMITER)
                    }
                    builder.append(LINE_BREAK)
                }
                builder.append(ARG_END)
                builder.append(LINE_BREAK)
            }
        }
        return builder
    }

    companion object {

        const val DATA_CLASS = "data "
        const val VAL_CONST = "val "
        const val VAL_DELIMITER = ": "
        const val ARG_START = '('
        const val ARG_END = ')'
        const val ARG_DELIMITER = ','
    }

}