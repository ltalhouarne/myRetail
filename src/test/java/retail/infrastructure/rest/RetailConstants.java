package retail.infrastructure.rest;

/**
 * @author Loic Talhouarne
 *
 *	Holds constants for testing suite.
 */
public class RetailConstants {
	public static final String NOT_FOUND_ERROR = "{\"code\":\"RecordNotFound\",\"message\":\"Item could not be found\"}";
	public static final String INVALID_REQUEST = "{\"code\":\"InvalidRequest\"";

	public static final String PRODUCT_NAME_NULL_ERROR = "{\"resource\":\"merchandiseItemDTO\",\"field\":\"productName\",\"code\":\"NotNull\",\"message\":\"may not be null\"}";
	public static final String DESCRIPTION_NULL_ERROR = "{\"resource\":\"merchandiseItemDTO\",\"field\":\"description\",\"code\":\"NotNull\",\"message\":\"may not be null\"}";
	public static final String PRICE_NULL_ERROR = "{\"resource\":\"merchandiseItemDTO\",\"field\":\"price\",\"code\":\"NotNull\",\"message\":\"may not be null\"}";
	public static final String AVAILABILITY_NULL_ERROR = "{\"resource\":\"merchandiseItemDTO\",\"field\":\"availability\",\"code\":\"NotNull\",\"message\":\"may not be null\"}";
	public static final String MERCHANDISE_CATEGORY_NULL_ERROR = "{\"resource\":\"merchandiseItemDTO\",\"field\":\"merchandiseCategory\",\"code\":\"NotNull\",\"message\":\"may not be null\"}";
	public static final String IMAGE_URL_NULL_ERROR = "{\"resource\":\"merchandiseItemDTO\",\"field\":\"imageUrl\",\"code\":\"NotNull\",\"message\":\"may not be null\"}";
	public static final String FEATURED_NULL_ERROR = "{\"resource\":\"merchandiseItemDTO\",\"field\":\"featured\",\"code\":\"NotNull\",\"message\":\"may not be null\"}";
	public static final String SHIPPING_COST_NULL_ERROR = "{\"resource\":\"merchandiseItemDTO\",\"field\":\"shippingCost\",\"code\":\"NotNull\",\"message\":\"may not be null\"}";
	public static final String BAR_CODE_NULL_ERROR = "{\"resource\":\"merchandiseItemDTO\",\"field\":\"barCode\",\"code\":\"NotNull\",\"message\":\"may not be null\"}";

	public static final String AVAILABILITY_ERROR = "{\"resource\":\"merchandiseItemDTO\",\"field\":\"availability\",\"code\":\"Available\",\"message\":\"Availability can only be 'Available/Unavailable'\"}";
	public static final String FEATURED_ERROR = "{\"resource\":\"merchandiseItemDTO\",\"field\":\"featured\",\"code\":\"Featured\",\"message\":\"Featured can only be 'Y/N''\"}";

	public static final String PRODUCT_NAME_TOO_SHORT_ERROR ="{\"code\":\"InvalidRequest\",\"message\":\"Invalid item: MerchandiseItem [id=null, productName=p, price=100, barcode=123456789, description=this is a description, merchandiseCategory=category, availability=available, shippingCost=100, imageUrl=http://test.com, bundle=null, featured=Y]\",\"fieldErrors\":[{\"resource\":\"merchandiseItemDTO\",\"field\":\"productName\",\"code\":\"Size\",\"message\":\"productName must be at least 2 characters long.\"}]}";
	public static final String BAR_CODE_TOO_LONG_ERROR ="{\"code\":\"InvalidRequest\",\"message\":\"Invalid item: MerchandiseItem [id=null, productName=product, price=10000, barcode=1234567899, description=this is a description, merchandiseCategory=category, availability=available, shippingCost=100, imageUrl=http://test.com, bundle=null, featured=Y]\",\"fieldErrors\":[{\"resource\":\"merchandiseItemDTO\",\"field\":\"barCode\",\"code\":\"Digits\",\"message\":\"numeric value out of bounds (<9 digits>.<0 digits> expected)\"}]}";
	public static final String CATEGORY_TOO_SHORT_ERROR = "{\"code\":\"InvalidRequest\",\"message\":\"Invalid item: MerchandiseItem [id=null, productName=productName, price=1000, barcode=123456789, description=this is a description, merchandiseCategory=c, availability=available, shippingCost=100, imageUrl=http://test.com, bundle=null, featured=Y]\",\"fieldErrors\":[{\"resource\":\"merchandiseItemDTO\",\"field\":\"merchandiseCategory\",\"code\":\"Size\",\"message\":\"merchandiseCategory must be at least 2 characters long.\"}]}";
	public static final String AVAILABLE_ERROR= "{\"code\":\"InvalidRequest\",\"message\":\"Invalid item: MerchandiseItem [id=null, productName=productName, price=1000, barcode=123456789, description=this is a description, merchandiseCategory=category, availability=a, shippingCost=100, imageUrl=http://test.com, bundle=null, featured=Y]\",\"fieldErrors\":[{\"resource\":\"merchandiseItemDTO\",\"field\":\"availability\",\"code\":\"Available\",\"message\":\"Availability can only be 'Available/Unavailable'\"}]}";
	public static final String WRONG_FEATURED_ERROR = "{\"code\":\"InvalidRequest\",\"message\":\"Invalid item: MerchandiseItem [id=null, productName=productName, price=1000, barcode=123456789, description=this is a description, merchandiseCategory=category, availability=available, shippingCost=100, imageUrl=http://test.com, bundle=null, featured=something]\",\"fieldErrors\":[{\"resource\":\"merchandiseItemDTO\",\"field\":\"featured\",\"code\":\"Featured\",\"message\":\"Featured can only be 'Y/N'\"}]}";
	public static final String DESCRIPTION_TOO_SHORT_ERROR = "{\"code\":\"InvalidRequest\",\"message\":\"Invalid item: MerchandiseItem [id=null, productName=productName, price=1000, barcode=123456789, description=t, merchandiseCategory=category, availability=available, shippingCost=100, imageUrl=http://test.com, bundle=null, featured=Y]\",\"fieldErrors\":[{\"resource\":\"merchandiseItemDTO\",\"field\":\"description\",\"code\":\"Size\",\"message\":\"description must be between 2 and 4000 characters long.\"}]}";
	public static final String LINK_TOO_SHORT_ERROR = "{\"code\":\"InvalidRequest\",\"message\":\"Invalid item: MerchandiseItem [id=null, productName=productName, price=1000, barcode=123456789, description=this is a description, merchandiseCategory=category, availability=available, shippingCost=100, imageUrl=http, bundle=null, featured=Y]\",\"fieldErrors\":[{\"resource\":\"merchandiseItemDTO\",\"field\":\"imageUrl\",\"code\":\"Size\",\"message\":\"imageUrl must be at least 5 characters long.\"}]}";
	public static final String PRICE_TOO_LARGE_ERROR = "{\"code\":\"InvalidRequest\",\"message\":\"Invalid item: MerchandiseItem [id=null, productName=product, price=1000000000, barcode=123456789, description=this is a description, merchandiseCategory=category, availability=available, shippingCost=100, imageUrl=http://test.com, bundle=null, featured=Y]\",\"fieldErrors\":[{\"resource\":\"merchandiseItemDTO\",\"field\":\"price\",\"code\":\"DecimalMax\",\"message\":\"The decimal value can not be more than 99999.99.\"}]}";
}
