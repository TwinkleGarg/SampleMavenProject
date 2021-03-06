/*
 * This file is part of WebGoat, an Open Web Application Security Project utility. For details,
 * please see http://www.owasp.org/
 * <p>
 * Copyright (c) 2002 - 2017 Bruce Mayhew
 * <p>
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 * <p>
 * Getting Source ==============
 * <p>
 * Source for this application is maintained at https://github.com/WebGoat/WebGoat, a repository for free software
 * projects.
 * <p>
 */

package org.owasp.webgoat.assignments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.owasp.webgoat.i18n.PluginMessages;

@AllArgsConstructor
public class AttackResult {

    public static class AttackResultBuilder {

        private boolean lessonCompleted;
        private PluginMessages messages;
        private Object[] feedbackArgs;
        private String feedbackResourceBundleKey;
        private String output;
        private Object[] outputArgs;

        public AttackResultBuilder(PluginMessages messages) {
            this.messages = messages;
        }

        public AttackResultBuilder lessonCompleted(boolean lessonCompleted) {
            this.lessonCompleted = lessonCompleted;
            this.feedbackResourceBundleKey = "lesson.completed";
            return this;
        }

        public AttackResultBuilder feedbackArgs(Object... args) {
            this.feedbackArgs = args;
            return this;
        }

        public AttackResultBuilder feedback(String resourceBundleKey) {
            this.feedbackResourceBundleKey = resourceBundleKey;
            return this;
        }

        public AttackResultBuilder output(String output) {
            this.output = output;
            return this;
        }

        public AttackResultBuilder outputArgs(Object... args) {
            this.outputArgs = args;
            return this;
        }

        public AttackResult build() {
            return new AttackResult(lessonCompleted, messages.getMessage(feedbackResourceBundleKey, feedbackArgs), messages.getMessage(output, output, outputArgs));
        }
    }

    @Getter
    private boolean lessonCompleted;
    @Getter
    private String feedback;
    @Getter
    private String output;


    public static AttackResultBuilder builder(PluginMessages messages) {
        return new AttackResultBuilder(messages);
    }

    public boolean assignmentSolved() {
        return lessonCompleted;
    }
}
