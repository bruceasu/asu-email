/*
 * Copyright (C) 2017 Bruce Asu<bruceasu@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *  　　
 * 　　The above copyright notice and this permission notice shall
 * be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package me.asu.email;

import lombok.Data;

@Data
public class MailMessage {
	private String subject;
	private String from;
	private String[] tos;
	private String[] ccs;
	private String[] bccs;
	private String content;
	private String[] fileNames;

	/**
	 * No parameter constructor.
	 */
	public MailMessage(){}

	/**
	 * Construct a MailMessage object.
	 */
	public MailMessage(String subject, String from, String[] tos,
			String[] ccs, String[] bccs, String content, String[] fileNames) {
		this.subject = subject;
		this.from = from;
		this.tos = tos;
		this.ccs = ccs;
		this.bccs = bccs;
		this.content = content;
		this.fileNames = fileNames;
	}
	/**
	 * Construct a simple MailMessage object.
	 */
	public MailMessage(String subject, String from, String to, String content) {
		this.subject = subject;
		this.from = from;
		this.tos = new String[]{to};
		this.content = content;
	}
	public static MailMessageBuilder builder() {
		return new MailMessageBuilder();
	}

	public static class MailMessageBuilder {
		private MailMessage mailMessage = new MailMessage();

		public MailMessage build() {
			return mailMessage;
		}

		public MailMessageBuilder subject(String subject) {
			mailMessage.setSubject(subject);
			return this;
		}

		public MailMessageBuilder from(String from) {
			mailMessage.setFrom(from);
			return this;
		}

		public MailMessageBuilder to(String... to) {
			mailMessage.setTos(to);
			return this;
		}

		public MailMessageBuilder cc(String... cc) {
			mailMessage.setCcs(cc);
			return this;
		}

		public MailMessageBuilder bcc(String... bcc) {
			mailMessage.setBccs(bcc);
			return this;
		}

		public MailMessageBuilder file(String... fileNames) {
			mailMessage.setFileNames(fileNames);
			return this;
		}

		public MailMessageBuilder content(String content) {
			mailMessage.setContent(content);
			return this;
		}
	}
}
