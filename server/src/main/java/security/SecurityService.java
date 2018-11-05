package security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class SecurityService {

	private static String secret = "soyUnCodigoSecreto";
	private static String claimName = "idEstudiante";
	
	public static Long user(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify(token);
			return jwt.getClaim(claimName).asLong();
		} catch (JWTVerificationException e) {
			throw new InvalidTokenException(e);
		}
	}
	
	public static String generarTokenPara(long id) {
		Algorithm algorithm = Algorithm.HMAC256(secret);
		String token = JWT.create()
		    .withClaim(claimName, id)
		    .sign(algorithm);
		
		return token;
	}

}