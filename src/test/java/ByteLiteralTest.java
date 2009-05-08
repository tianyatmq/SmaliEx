/*
 * [The "BSD licence"]
 * Copyright (c) 2009 Ben Gruver
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.junit.*;
import org.JesusFreke.smali.literalTools;

public class ByteLiteralTest
{

    @Test
    public void SuccessHexTests() {

        Assert.assertTrue(literalTools.parseByte("0x0T") == 0x0);
        Assert.assertTrue(literalTools.parseByte("0x00") == 0x0);
        Assert.assertTrue(literalTools.parseByte("0x1T") == 0x1);
        Assert.assertTrue(literalTools.parseByte("0x12") == 0x12);
        Assert.assertTrue(literalTools.parseByte("0x7fT") == 0x7f);
        Assert.assertTrue(literalTools.parseByte("0x80t") == Byte.MIN_VALUE);
        Assert.assertTrue(literalTools.parseByte("0xFFt") == -1);

        Assert.assertTrue(literalTools.parseByte("-0x00") == 0);
        Assert.assertTrue(literalTools.parseByte("-0x01") == -1);
        Assert.assertTrue(literalTools.parseByte("-0x12") == -0x12);
        Assert.assertTrue(literalTools.parseByte("-0x80") == Byte.MIN_VALUE);
    }

    @Test(expected=NumberFormatException.class)
    public void FaileHexTest1() {
        literalTools.parseByte("-0x81");
    }

    @Test(expected=NumberFormatException.class)
    public void FailHexTest2() {
        literalTools.parseByte("-0xFF");
    }

    @Test(expected=NumberFormatException.class)
    public void FailHexTest3() {
        literalTools.parseByte("0x100");
    }



    @Test
    public void SuccessDecTests() {
        Assert.assertTrue(literalTools.parseByte("0") == 0);
        Assert.assertTrue(literalTools.parseByte("1t") == 1);
        Assert.assertTrue(literalTools.parseByte("123") == 123);
        Assert.assertTrue(literalTools.parseByte("127T") == 127);
        Assert.assertTrue(literalTools.parseByte("128") == Byte.MIN_VALUE);
        Assert.assertTrue(literalTools.parseByte("255") == -1);


        Assert.assertTrue(literalTools.parseByte("-0") == 0);
        Assert.assertTrue(literalTools.parseByte("-1") == -1);
        Assert.assertTrue(literalTools.parseByte("-123") == -123);
        Assert.assertTrue(literalTools.parseByte("-127") == -127);
        Assert.assertTrue(literalTools.parseByte("-128") == Byte.MIN_VALUE);
    }

    @Test(expected=NumberFormatException.class)
    public void FaileDecTest1() {
        literalTools.parseByte("-129");
    }

    @Test(expected=NumberFormatException.class)
    public void FailDecTest2() {
        literalTools.parseByte("-255");
    }

    @Test(expected=NumberFormatException.class)
    public void FailDecTest3() {
        literalTools.parseByte("256");
    }

    @Test(expected=NumberFormatException.class)
    public void FailDecTest4() {
        literalTools.parseByte("260");
    }


    @Test
    public void SuccessOctTests() {
        Assert.assertTrue(literalTools.parseByte("00") == 00);
        Assert.assertTrue(literalTools.parseByte("01") == 01);
        Assert.assertTrue(literalTools.parseByte("0123t") == 0123);
        Assert.assertTrue(literalTools.parseByte("0177") == Byte.MAX_VALUE);
        Assert.assertTrue(literalTools.parseByte("0200T") == Byte.MIN_VALUE);
        Assert.assertTrue(literalTools.parseByte("0377") == -1);


        Assert.assertTrue(literalTools.parseByte("-00") == 0);
        Assert.assertTrue(literalTools.parseByte("-01") == -1);
        Assert.assertTrue(literalTools.parseByte("-0123") == -0123);
        Assert.assertTrue(literalTools.parseByte("-0177") == -0177);
        Assert.assertTrue(literalTools.parseByte("-0200") == Byte.MIN_VALUE);
    }

    @Test(expected=NumberFormatException.class)
    public void FaileOctTest1() {
        literalTools.parseByte("-0201");
    }

    @Test(expected=NumberFormatException.class)
    public void FailOctTest2() {
        literalTools.parseByte("-0377");
    }

    @Test(expected=NumberFormatException.class)
    public void FailOctTest3() {
        literalTools.parseByte("0400");
    }
}
