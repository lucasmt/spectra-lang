/*
Copyright (c) since 2015, Tel Aviv University and Software Modeling Lab

All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of Tel Aviv University and Software Modeling Lab nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL Tel Aviv University and Software Modeling Lab 
BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
*/

package tau.smlab.syntech.typesystem;

import tau.smlab.syntech.spectra.SizeDefineDecl;
import tau.smlab.syntech.spectra.SpectraPackage;
import tau.smlab.syntech.spectra.VarType;

public class TypeSystemVarType {
	public static TypeCheckIssue typeCheck(VarType varType) {

		if (!legelDimensions(varType))
		{
			return new TypeCheckError(SpectraPackage.Literals.VAR_TYPE.getEIDAttribute(), IssueMessages.NON_INT_VAR_DIMEMSION);
		}
		return null;
	}
	
	//checks if the dimensions we gave to the array is legal
	private static boolean legelDimensions(VarType varType)
	{
		if(varType.getDimensions() != null && varType.getDimensions().size() > 0) {
			for(SizeDefineDecl sdd : varType.getDimensions()) {
				if(TypeSystemUtils.sizeDefineToInt(sdd) < 0) {
					return false;
				}
				else {
					if(TypeSystemUtils.sizeDefineToInt(sdd) <= 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
